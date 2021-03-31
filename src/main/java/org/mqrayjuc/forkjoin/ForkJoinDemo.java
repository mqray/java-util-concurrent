package org.mqrayjuc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author ray
 * Date 2021/3/30
 * 求和计算的任务
 * 1.forkjoinPool
 * 2. 计算任务forkjoinPool.execute(ForkJoinTask task)
 * 3. 计算类要继承RecursiveTask
 */

public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;  // 1
    private Long end; // 1990900000 // 临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    // 计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else { // forkjoin 递归
            long middle = (start + end) / 2; // 中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork(); // 拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);
            task2.fork(); // 拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}