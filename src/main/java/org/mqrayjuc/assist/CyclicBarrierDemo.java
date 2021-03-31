package org.mqrayjuc.assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ray
 * Date 2021/3/30
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("success");
        });

        for (int i = 0; i < 7; i++) {
            final int tmp = i;
            // lambda能用到i么？
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "收集" + tmp + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
