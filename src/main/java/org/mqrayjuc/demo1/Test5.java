package org.mqrayjuc.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/29
 * 线程八锁 就是关于锁的八个问题
 * 6. 一个是普通同步方法 一个是静态同步方法，打印顺序
 *    先打电话 后发短信
 *    两个锁持有对象不同，而发短信的需要等4s 打电话的不用等待
 *  7. 再加一个对象，分别调用打电话和发短信
 *      持有锁的对象不一致 等待时间较短的先打印
 */
public class Test5 {

    public static void main(String[] args) throws InterruptedException {

        Phone4 phone = new Phone4();

        new Thread(()->{
            try {
                Phone4.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
//            phone.hello();
            phone.call();
        },"B").start();
    }
}

class Phone4{

    public static synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public /*static*/ synchronized void call(){
        System.out.println("打电话");
    }
}
