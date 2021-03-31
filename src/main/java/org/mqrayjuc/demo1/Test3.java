package org.mqrayjuc.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/29
 * 线程八锁 就是关于锁的八个问题
 * 3. 增加一个普通方法， 打印顺序 先打印hello，再打印 发短信
 * 因为 hello不受phone锁的影响
 * 4. 如果有两个对象，两个对象执行不同的同步方法，打印顺序
 *  两个不同的对象 都拥有锁 先打印 打电话，4s后打印发短信
 *  因为 发短信的延时更长
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
//            phone.hello();
            phone2.call();
        },"B").start();
    }
}

class Phone2{

    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}
