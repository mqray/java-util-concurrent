package org.mqrayjuc.pool;

import java.util.concurrent.*;

/**
 * @author ray
 * Date 2021/3/30
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                6,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(4),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        try {
            for (int i = 1; i < 10; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            threadPoolExecutor.shutdown();
        }
    }
}
