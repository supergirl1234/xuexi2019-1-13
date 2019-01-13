package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread6 {

    public static void main(String[] args) {

       /* Thread thread1=new Thread();
        System.out.println(thread1.isDaemon());//主线程是非守护线程，是用户线程
        thread1.setDaemon(true);//设置其为守护线程
        System.out.println(thread1.isDaemon());*/

       Runnable runnable=new My3();

       //只要当前JVM进程中存在任何一个非守护线程没有结束，守护线程就在工作；只有当最后一个非守护线程结束时，守护线程才会随着JVM一同停止工作。
       Thread threadA=new Thread(runnable,"线程1");
        threadA.setDaemon(true);//守护线程
       threadA.start();

       Thread threadB=new Thread(runnable,"线程2");
       threadB.start();//用户线程

       Thread threadC=new Thread(runnable,"线程3");
        threadC.start();//用户线程
        try {
            Thread.sleep(4000);
            threadB.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


class My3 implements Runnable{


    @Override
    public void run() {
       int i=0;
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "这是第" + i++ + "次");
                Thread.sleep(1000);

            }
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 中断");
        }
    }
}