package com;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread11 {


    public static void main(String[] args) {
        Sync2 sync2=new Sync2();
        for(int i=0;i<3;i++){
            Thread t=new My6(sync2);
            t.setName("Thread"+i);
            t.start();

        }

    }
}


class Sync2{


    public synchronized  void test(){

        System.out.println("Syn对象的Test方法执行开始："+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Syn对象的Test方法执行结束："+Thread.currentThread().getName());
    }
}

class My6 extends Thread{


    private  final Sync2 sync;
    public My6(Sync2 sync){
        this.sync=sync;

    }

    @Override
    public void run() {
        sync.test();
    }
}