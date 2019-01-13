package com;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread9 {

    public static void main(String[] args) {
        Runnable runnable=new My5();
        for(int i=0;i<10;i++){

            new Thread(runnable,"Thead-"+i).start();
        }

    }
}
class My5 implements Runnable{

private int i=0;
    @Override
    public synchronized void run() {

        System.out.println("@#"+Thread.currentThread().getName()+"-"+i++);
    }
}