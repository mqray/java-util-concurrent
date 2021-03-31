package org.mqrayjuc.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/31
 */
public class SpinLockTest {

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(()->{
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myunlock();
            }
        },"t1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.myunlock();
            }
        },"t2").start();
    }
}
