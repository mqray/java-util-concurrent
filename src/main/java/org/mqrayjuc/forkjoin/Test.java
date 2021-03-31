package org.mqrayjuc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author ray
 * Date 2021/3/30
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1(); // 626
        test2();//9381
//        test3();    // 1042
    }

    public static void test1(){
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间 " + (end-start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
//        forkJoinPool.execute(forkJoinDemo);//没有结果
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间 " + (end-start));
    }

    public static void test3(){
        long start = System.currentTimeMillis();
        long sum = LongStream.range(0, 10_0000_0000).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间 " + (end-start));
    }
}
