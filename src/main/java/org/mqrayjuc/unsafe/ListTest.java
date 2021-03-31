package org.mqrayjuc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ray
 * Date 2021/3/29
 * ConcurrentModificationException
 */
public class ListTest {

    public static void main(String[] args) {

//        List<String> list = Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
        // 并发下 ArrayList不安全,
        // 解决方案
        // 1. Vector线程安全 而vector是jdk 1.0出现的 而arraylist是jdk1.5出现的
        // 2. Collections.synchronizedList是线程安全的
        // 3. juc下的CopyOnWriteArrayList COW写时复制 写入时避免覆盖造成数据问题
        // CopyOnWriteArrayList 比 vector好在哪？vector是悲观锁，使用synchronized，而COW是乐观锁，使用lock锁

//        List<String> list1 = new ArrayList<>();
//        List<String> list1 = new Vector<>();
//        List<String> list1 = Collections.synchronizedList(new ArrayList<>());
        List<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(()->{
                list1.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list1);
            },String.valueOf(i)).start();
        }
    }
}
