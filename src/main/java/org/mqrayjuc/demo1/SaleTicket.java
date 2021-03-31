package org.mqrayjuc.demo1;

/**
 * @author ray
 * Date 2021/3/29
 */
public class SaleTicket {

    public static void main(String[] args) {
        final Ticket ticket = new Ticket();

        new  Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        },"a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    ticket.sale();
                }
            }
        }, "b").start();

        // 将匿名内部类修改为lambda会更好一些
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        },"c").start();
    }
}


class Ticket{

    private int number = 70;

    public /*synchronized*/ void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票，剩余" + number + "张票");
        }
    }
}