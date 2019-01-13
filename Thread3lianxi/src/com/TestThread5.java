package com;

import java.time.LocalDateTime;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread5 {
    public static void main(String[] args) {
       Runnable runnable=new My2();

       Thread thread1=new Thread(runnable,"线程1");
       thread1.start();



        try {

            //主线程休眠
            Thread.sleep(4000);
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
class My2 implements Runnable {


    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName()+"初始"+ LocalDateTime.now() );

            try {
                //判断线程的中断情况
                boolean interruptedstatus = Thread.currentThread().isInterrupted();
                if (interruptedstatus) {
                    break;
                }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("阻塞中断" + Thread.currentThread().isInterrupted());
                return;
            }


        }
    }
}
