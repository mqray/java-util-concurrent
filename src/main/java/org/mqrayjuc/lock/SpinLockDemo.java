package org.mqrayjuc.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ray
 * Date 2021/3/31
 * 自旋锁
 */
public class SpinLockDemo {

    AtomicReference atomicReference = new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "  ==> mylock");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myunlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "  ==> myunlock");
        atomicReference.compareAndSet(thread,null);
    }
}
