package com.course.testng.suite;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//测试套件之前，一些共有的东西
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite运行啦 ");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("aftersuite运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforetest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("afterTest");
    }


}
