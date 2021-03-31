package org.mqrayjuc.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ray
 * Date 2021/3/29
 * A-B-C顺序执行
 */
public class C {

    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}


//等待 业务 通知

class Data3 {

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int number = 1; // A -1 B 2 C 3

    public void printA(){
        lock.lock();
        try {
            //业务、判断、执行、通知
            while(number!=1){
                // 等待
                condition1.await();
            }
            // 业务逻辑
            System.out.println(Thread.currentThread().getName() + "==>AAAA");
            // 唤醒指定的人 B
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            //业务、判断、执行、通知
            while(number != 2){
                // 等待
                condition2.await();
            }
            // 业务逻辑
            System.out.println(Thread.currentThread().getName() + "==>BBBB");
            // 精准唤醒C
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            //业务、判断、执行、通知
            while(number != 3){
                condition3.await();
            }
            // 业务逻辑
            System.out.println(Thread.currentThread().getName() + "==>CCCC");
            // 精准唤醒A
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

