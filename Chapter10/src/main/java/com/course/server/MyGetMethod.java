package com.course.server;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//告诉application.java我是一个需要被扫描的类
@RestController
public class MyGetMethod {
    @RequestMapping(value ="/getCookies",method = RequestMethod.GET)//我的访问路径是什么
    public String getCookies(){
        return "liyan success";
    }
}
