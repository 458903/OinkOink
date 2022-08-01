package com.course.system.controller;

import com.course.server.domain.Test;
import com.course.server.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController//用来返回json格式的数据。如果要返回一个页面，那就用@Controller注解
public class TestController {
    @Resource
    private TestService testService;
    @RequestMapping("/one")
    public String est(){
        return "okk";
    }
    @RequestMapping("/test")
    public List<Test> test(){
        return testService.list();
    }
}
