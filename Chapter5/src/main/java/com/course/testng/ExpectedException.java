package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /*
    在我们期望结果为某一个异常的时候
    比如：我们传入了某些不合法的参数，程序跑出了异常
    也就是说我们的预期结果就是这个异常
     */

    //测试结果为失败的异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    //成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSucess(){

        System.out.println("这是一个成功的异常测试");
        //throw这行一定要写在下面，要不然报异常
        throw new RuntimeException();
    }
}
