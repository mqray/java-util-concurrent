package org.mqrayjuc.singleton;

/**
 * @author ray
 * Date 2021/3/31
 * 饿汉式单例 --> 构造器私有
 * 可能会浪费空间，提前将尚未使用到的空间分配
 */
public class Hungry {

    private Hungry(){}

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
