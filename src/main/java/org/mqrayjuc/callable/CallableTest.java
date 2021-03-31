package org.mqrayjuc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ray
 * Date 2021/3/29
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(new Runnable() ).start();
//        new Thread(new FutureTask() ).start();
//        new Thread(new FutureTask<V>(Callable) ).start();
        // 相较 runnable ，callable可以有返回值，可以抛出异常，runnble是重写run方法，callable是call方法
        // get()方法可能被阻塞
        new Thread().start();

        MyThread2 thread2 = new MyThread2();
        FutureTask futureTask = new FutureTask(thread2); // 适配类

        new Thread(futureTask,"A").start(); // 正常这里应该会被打印两次，但是只输出了一次，是为什么？ 结果被缓存了
        new Thread(futureTask,"B").start(); //
        System.out.println(futureTask.get()); // get()方法可能被阻塞

    }
}


class MyThread implements Runnable{
    // runnable功能有限 没有返回值
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("-----------");
        return "124";
    }
}