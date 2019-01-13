package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread1 {

    public static void main(String[] args) {

       Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "当前时间2为：" + LocalDateTime.now());
                }
            }
        };

        Thread thread1=new Thread(runnable,"线程1");

        System.out.println(Thread.currentThread().getName() + "当前时间1为：" + LocalDateTime.now());//main
        try {
            Thread.sleep(1000);//1S
            System.out.println(Thread.currentThread().getName() + "当前时间1为：" + LocalDateTime.now());//main
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();

        /*Thread thread2=new Thread(runnable,"线程2");
        System.out.println(Thread.currentThread().getName() + "当前时间3为：" + LocalDateTime.now());
        thread2.start();*/





    }
}
