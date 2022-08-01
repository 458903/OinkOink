package com.course.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//用来返回json格式的数据。如果要返回一个页面，那就用@Controller注解
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "okk";
    }

}
