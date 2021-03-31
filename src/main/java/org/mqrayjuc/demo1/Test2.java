package org.mqrayjuc.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/29
 * 线程八锁 就是关于锁的八个问题
 *1. 先打印发短信还是打电话？ 先发短信后打电话
 * 2. 发短信的方法延时4s，如何输出？ 先发短信后打电话
 *  原因是锁的存在 synchronized 锁的对象是 方法的调用者phone，谁先拿到谁就先执行
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone{

    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}