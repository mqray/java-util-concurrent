package org.mqrayjuc.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ray
 * Date 2021/3/29
 * 依旧会报ConcurrentModificationException异常
 */
public class MapTest {

    public static void main(String[] args) {
        // 工作中不这样用
//        Map<String , String > map = new HashMap<>();
//        Map<String , String > map = Collections.synchronizedMap(new HashMap<>());
        Map<String , String > map = new ConcurrentHashMap<>();

        // loadfactory = 0.75和 init容量DEFAULT_INITIAL_CAPACITY = 1 << 4
        // 解决方案
        // 1. Collections.synchronizedMap(new HashMap<>())
        // 2. juc的new ConcurrentHashMap<>(); 研究ConcurrentHashMap的原理
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,4));
                System.out.println(map);
            },String.valueOf(i).toString()).start();
        }
    }
}
