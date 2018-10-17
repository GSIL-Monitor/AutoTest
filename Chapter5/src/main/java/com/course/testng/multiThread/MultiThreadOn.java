package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOn {
    //10个线程

    //invocationCount默认是1，一个线程池,多线程执行顺序无法控制，使用注解实现多线程，
    // 不要用跨线程变量关联，否则需要加锁，比较难
    //@Test(invocationCount = 10)打印线程id发现id全都是1，加上threadPoolSize后，id变成10、11、12
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println("a");
        //打印线程id
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
