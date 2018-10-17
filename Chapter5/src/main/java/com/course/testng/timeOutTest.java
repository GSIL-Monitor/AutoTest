package com.course.testng;

import org.testng.annotations.Test;

public class timeOutTest {
    @Test(timeOut = 3000)//单位为毫秒
    public void  testSuccess() throws InterruptedException{

    }

    @Test(timeOut = 2000)
    public void testFailed(){
        //Thread.sleep(millis:2000);
    }
}


