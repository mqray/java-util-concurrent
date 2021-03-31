package org.mqrayjuc.assist;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/30
 * semaphore.acquire();
 * semaphore.release();
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 资源数量
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                // acquire 请求资源
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "请求到资源");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                // release 释放资源
            },String.valueOf(i).toString()).start();
        }
    }
}
