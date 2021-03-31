package org.mqrayjuc.singleton;

/**
 * @author ray
 * Date 2021/3/31
 */
public class DCLLazyMan {

    private DCLLazyMan(){
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    // 注意 下面的getInstance中，new一个对象并不是原子操作，
    // 多线程环境下可能会因为指令重排序导致第一个if判断失败直接返回对象，但是对象可能尚未完全初始化
    // 最完整的方法是给对象加一个volatile关键字

    private volatile static DCLLazyMan dclLazyMan;

    // 基于双重检测机智的单例模式

    public static DCLLazyMan getInstance(){
        if(dclLazyMan==null){
            synchronized (DCLLazyMan.class){
                if(dclLazyMan==null){
                    dclLazyMan = new DCLLazyMan();
                }
            }
        }
        return dclLazyMan;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                DCLLazyMan.getInstance();
            }).start();
        }
    }
}
