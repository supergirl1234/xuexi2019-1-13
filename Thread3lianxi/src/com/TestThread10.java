package com;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread10 {

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            Thread thread=new MyThread();
            thread.setName("Thread"+i);
            thread.start();

        }

    }
}

class Sync{


    public synchronized void  test(){


        System.out.println("Syn对象的Test方法执行开始："+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Syn对象的Test方法执行结束："+Thread.currentThread().getName());
    }
}
class MyThread extends Thread{

    @Override
    public void run() {
        Sync sync=new Sync();
        sync.test();
    }
}