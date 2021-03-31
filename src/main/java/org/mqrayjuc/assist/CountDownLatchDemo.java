package org.mqrayjuc.assist;

import java.util.concurrent.CountDownLatch;

/**
 * @author ray
 * Date 2021/3/30
 * 减法计数器
 * countDownLatch.countDown();
 * countDownLatch.await();
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " out");
                countDownLatch.countDown();
            },String.valueOf(i).toString()).start();
        }
        countDownLatch.await(); // 等待计数器归0， 在执行后续代码
        System.out.println("close door");
    }
}
