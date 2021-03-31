package org.mqrayjuc.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @author ray
 * Date 2021/3/31
 * 下面程序的目的是
 * 子线程读取到工作内存中num=0，死循环
 * 当主线程修改num值为1之后，子线程应该读取到修改，结束死循环
 * 但是这里main线程的修改对子线程不可见
 * 直到对这个变量加上了volatile关键字
 * 防止指令重排序
 * 保证可见性
 * 不保证原子性
 *
 * 如何验证 不保证原子性
 */
public class VolatileTest {

    static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while(num==0){

            }
        }).start();
        TimeUnit.SECONDS.sleep(2);
        num = 1;
        System.out.println(num);
    }
}
