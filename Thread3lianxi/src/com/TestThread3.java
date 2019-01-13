package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread3 {

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){

                    System.out.println(Thread.currentThread().getName()+"i="+i);

                }
            }
        };

       Thread thread1=new Thread(runnable,"线程1");
        System.out.println(Thread.currentThread().getName()+"当前时间为："+LocalDateTime.now());
       try {
           thread1.join();//阻塞主线程，当run方法执行完毕才会继续执行主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        System.out.println(Thread.currentThread().getName()+"当前时间为："+LocalDateTime.now());



    }
}
