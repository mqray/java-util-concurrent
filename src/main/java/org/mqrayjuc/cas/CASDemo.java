package org.mqrayjuc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author ray
 * Date 2021/3/31
 */
public class CASDemo {


    public static void main(String[] args) {
        // 如何解决CAS的ABA问题
//        AtomicInteger atomicInteger = new AtomicInteger(2021);
//        atomicInteger.compareAndSet(2021,2022);
//        System.out.println(atomicInteger.get());
//        atomicInteger.compareAndSet(2022,2021);
//        System.out.println(atomicInteger.get());
//        atomicInteger.compareAndSet(2021,6666);
//        System.out.println(atomicInteger.get());

        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a stamp ==>"+ stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(1,2,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("a stamp ==>" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(2,1,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println("a stamp ==>" + atomicStampedReference.getStamp());
        },"a").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b stamp ==>" + stamp);
            atomicStampedReference.compareAndSet(1,6666,stamp,stamp+1);
            System.out.println("b stamp ==>" + atomicStampedReference.getStamp());
        },"b").start();

    }

}
