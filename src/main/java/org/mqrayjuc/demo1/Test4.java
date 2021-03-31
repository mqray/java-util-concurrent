package org.mqrayjuc.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/29
 * 线程八锁 就是关于锁的八个问题
 * 5. 将同步方法改为静态同步方法 ，只有一个对象 打印顺序是什么？
 *  先发短信再打电话 static类一加载就有了
 *  由于将同步方法改为了静态同步方法，则持有锁的对象是类本身xx.class 而不是实例对象
 *  所以先打印 发短信，再打印 打电话
 */
public class Test4 {

    public static void main(String[] args) throws InterruptedException {

        Phone3 phone = new Phone3();

        new Thread(()->{
            try {
                Phone3.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
//            phone.hello();
            Phone3.call();
        },"B").start();
    }
}

class Phone3{

    public static synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }
}
