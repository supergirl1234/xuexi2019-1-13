package com;

import java.time.LocalDateTime;

import static java.lang.Thread.*;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread4 {
    public static void main(String[] args) {
        Runnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable,"线程1");
        thread1.start();

     try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +LocalDateTime.now());
            //修改标记位
            ((MyRunnable) runnable).setFlag(false);//这三句的意思是主线程延时多少秒后再将flag置为false，终止线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //((MyRunnable) runnable).setFlag(false);//如果没有主线程延时的话，直接就将flag置为false，终止线程了
       /* try {
            thread1.sleep(2000);
            System.out.println(Thread.currentThread().getName() +LocalDateTime.now());
            ((MyRunnable) runnable).setFlag(false);//这三句的意思是线程延时多少秒后再将flag置为false，终止线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}


class MyRunnable implements  Runnable{

    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(flag){
            try {
                Thread.sleep(1000);//睡眠1S，要不然运行太快
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "循环执行第" + i++ + "次"+LocalDateTime.now());


        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}