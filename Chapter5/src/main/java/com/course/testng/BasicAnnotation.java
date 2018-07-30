package com.course.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by liyan204519 on 2018/7/27.
 */
public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("test1");
    }

    @Test
    public void testCase2(){
        System.out.println("test3");
    }
   @BeforeMethod
    public void beforeMethod() {
           System.out.println("before method");

   }

    @AfterMethod
    public void afterMethod() {
        System.out.println("after method");


    }

}
