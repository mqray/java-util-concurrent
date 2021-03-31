package org.mqrayjuc.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ray
 * Date 2021/3/29
 * 同样会出现ConcurrentModificationException错误
 */
public class SetTest {

    public static void main(String[] args) {
//        Set<Object> set = new HashSet<>();
        // 解决方案
        // 1. Collections.synchronizedSet(new HashSet<>())
        // 2. juc里面的new CopyOnWriteArraySet<>();
        // hashset的底层原理是什么？底层就是new hashmap()
//        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Set<Object> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i).toString()).start();
        }
    }
}
