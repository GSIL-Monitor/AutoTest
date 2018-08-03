package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public  void test1(){
        int i1=1;
        int i2=2;
        Assert.assertEquals(i1,i2);

    }
    @Test
    public void test2(){
        int i3=1;
        int i4=2;
        Assert.assertEquals(i3,i4);
    }

    @Test
    public void test3(){
        int i5=1;
        int i6=2;
        Assert.assertEquals(i5,i6);
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们自己的日志");
        throw new RuntimeException("这是我自己运行时的异常");
    }


}
