package org.mqrayjuc.singleton;

/**
 * @author ray
 * Date 2021/3/31
 * 静态内部类实现单例模式
 * 单例模式都是构造器私有
 */
public class Holder {

    private Holder(){}

    // 但是不是安全的

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
