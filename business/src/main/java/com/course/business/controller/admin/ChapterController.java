package com.course.business.controller.admin;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseDto list(PageDto pageDto){
        ResponseDto responseDto=new ResponseDto();
         chapterService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
    }
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ResponseDto save(ChapterDto chapterDto){
        ResponseDto responseDto=new ResponseDto();
         chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public ResponseDto delete(@PathVariable("id") String id){
        ResponseDto responseDto=new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }
}
