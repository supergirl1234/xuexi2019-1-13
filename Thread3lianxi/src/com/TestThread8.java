package com;

/**
 * Author:Fanleilei
 * Created:2019/1/13 0013
 */
public class TestThread8 {
    public static void main(String[] args) {
        Runnable runnable=new My4();

        Thread thread1=new Thread(runnable,"售票员1");
        Thread thread2=new Thread(runnable,"售票员2");
        Thread thread3=new Thread(runnable,"售票员3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class My4 implements Runnable{

    private int ticket=10;




    /*@Override
    public void run() {

          while (ticket > 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            System.out.println(Thread.currentThread().getName()+"票卖光了");

    }*/
/*

   @Override
    public void run() {

       synchronized (this) {

           while (ticket > 0) {
               try {
                   Thread.sleep(1000);
                   System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
           System.out.println(Thread.currentThread().getName() + "票卖光了");
       }
   }
*/

   /* @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("----------------");

            synchronized (this) {


                while (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }

        }
        System.out.println(Thread.currentThread().getName() + "票卖光了");
    }
*/
   /* @Override
    public synchronized void run() {

        for(int i=0;i<10;i++){
            if(this.ticket>0){

                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
        System.out.println(Thread.currentThread().getName()+"票卖光了");

    }*/


   @Override
   public void run() {
       for(int i=0;i<10;i++){

           System.out.println("--------------");
           sale();
       }
       System.out.println(Thread.currentThread().getName()+"票卖完了");

   }
   //同步方法
   private synchronized void sale() {

       if(this.ticket>0){
           try {
               Thread.sleep(1000);
               System.out.println(Thread.currentThread().getName() + "还剩" + ticket-- + "张票");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }
   }


}