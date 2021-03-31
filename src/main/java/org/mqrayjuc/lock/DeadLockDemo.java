package org.mqrayjuc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/31
 * 如何发现死锁？
 * jps -l 一直没有结束的线程
 * 查看堆栈信息 jstack pid
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyThread(lockA,lockB),"t1").start();
        new Thread(new MyThread(lockB,lockA),"t2").start();

    }

}

class MyThread implements Runnable{

    private String lockA;
    private String lockB;

    public MyThread(String lockA, String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + " lock: " + lockA + "==> get " + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + " lock: " + lockB + "==> get " + lockA);
            }
        }
    }
}
