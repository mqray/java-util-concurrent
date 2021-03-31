package org.mqrayjuc.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ray
 * Date 2021/3/29
 */
public class SaleTicket2 {

    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"a").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }
        , "b").start();

        // 将匿名内部类修改为lambda会更好一些
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"c").start();
    }
}


class Ticket2{

    private int number = 70;

    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票，剩余" + number + "张票");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }

    }
}
