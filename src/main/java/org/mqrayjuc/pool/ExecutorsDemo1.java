package org.mqrayjuc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ray
 * Date 2021/3/30
 * 三大方法，7个参数，3种拒绝策略
 * 使用线程池创建
 * int corePoolSize,
 * int maximumPoolSize,
 * long keepAliveTime,
 * TimeUnit unit,
 * BlockingQueue<Runnable> workQueue,
 * ThreadFactory threadFactory,
 * RejectedExecutionHandler handler) {
 */
public class ExecutorsDemo1 {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单一线程
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newCachedThreadPool();// 可伸缩
        try {
            for (int i = 0; i < 1000; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            executorService.shutdown();
        }

    }
}
