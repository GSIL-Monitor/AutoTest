package com.course.testng;

import org.testng.annotations.*;

public class Basic {
    @Test
    public void testCase1(){
        System.out.println("test1");
    }

    @Test
    public void testCase02(){
        System.out.println("test2");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeclass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterclass");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforemethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }


    //suite包含多个class，运行在类之前/之后
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("aftresuite测试套件");
    }




}
