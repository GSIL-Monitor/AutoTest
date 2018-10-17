package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//告诉application.java我是一个需要被扫描的类
//@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RestController
@Api(value = "/",description = "this is my all get method")    //在swagger上加上接口
public class MyGetMethod {

    @RequestMapping(value ="/getCookies",method = RequestMethod.GET)//我的访问路径是什么
    @ApiOperation(value = "get cookies with this method",httpMethod = "GET")  //在swagger上加上接口（方法上加）
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest装请求信息的类
        //HttpServletResponse装相应信息的类
        //在response中返回cookies信息
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "liyan success";
    }
//要求客户端携带cookies信息访问
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "client must with cookies ",httpMethod = "GET")  //在swagger上加上接口（方法上加
    public String getWithCookies(HttpServletRequest request){
        //cookies数组
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "must with cookies11";

        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("ture")){
                return "success";
            }
        }
        return "must with cookies";


    }

    //开发一个需要携带参数才能访问的get请求，
    // 第一种实现方式：key=value&key=value
    //模拟获取商品列表
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "client must with param ",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("xie",400);
        myList.put("mian",1);
        myList.put("yifu",300);
        return myList;
    }
    // 第二种实现方式：url:ip:port/get/with/param/10/20
    //模拟获取商品列表
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "client must with param second method ",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("xie",400);
        myList.put("mian",1);
        myList.put("yifu",300);
        return myList;
    }



}
