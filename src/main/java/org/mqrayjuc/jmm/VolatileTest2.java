package org.mqrayjuc.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ray
 * Date 2021/3/31
 * 证明volatile不保证原子性
 * 在num上添加synchronized保证是2w，加volatile不保证是2w
 * 如果不加lock和synchronized如何保证原子性
 * 使用原子类，
 */
public class VolatileTest2 {

//    private volatile static int num = 0;

    private static AtomicInteger num = new AtomicInteger();

    public static void add(){
//        num++; // 不是原子操作
        num.getAndIncrement();
    }

    public static void main(String[] args) {

        // 理论上结果是2w，但是++操作不是原子的，
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2 ){
            // main + gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
