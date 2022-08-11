package com.course.business.controller.admin;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
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
    public PageDto list(PageDto pageDto){
         chapterService.list(pageDto);
         return pageDto;
    }
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ChapterDto save(ChapterDto chapterDto){
         chapterService.save(chapterDto);
         return chapterDto;
    }
}
