package com;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread2 {

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
               for (int i=0;i<3;i++){
                   Thread.yield();
                   System.out.println(Thread.currentThread().getName()+"i="+i);
               }
            }
        };

        Thread thread1=new Thread(runnable,"线程1");
        thread1.start();
        Thread thread2=new Thread(runnable,"线程2");
        thread2.start();
        Thread thread3=new Thread(runnable,"线程3");
        thread3.start();
    }
}
