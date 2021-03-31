package org.mqrayjuc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/30
 */
public class AsyncDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的runAsync异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync->Void");
//        });
//        System.out.println("-----------");
//        completableFuture.get();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "runAsync->Void");
            int i =10/0;
            return 1024;
        });
        System.out.println(completableFuture.whenCompleteAsync((t, u) -> {
            System.out.println("t ==> " + t);
            System.out.println("u ==> " + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
