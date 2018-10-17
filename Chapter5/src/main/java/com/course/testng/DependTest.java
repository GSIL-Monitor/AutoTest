package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test run1");
        //假如test1失败了，test2就被忽略掉
        throw new RuntimeException();
    }

    //依赖test1
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test run2");
    }
}
