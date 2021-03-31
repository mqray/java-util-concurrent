package org.mqrayjuc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ray
 * Date 2021/3/31
 * 懒汉式单例模式
 */
public class LazyMan {

    private static boolean flag = false;

    private LazyMan(){
//        synchronized (LazyMan.class){
//            if(lazyMan!=null){
//                throw new RuntimeException("不要试图使用反射破坏单例");
//            }
//        }
        synchronized (LazyMan.class){
            if(flag==false){
                flag = true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
        }
//        System.out.println(Thread.currentThread().getName()+" ok");
    }

    private static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if(lazyMan==null){
            lazyMan = new LazyMan();
        }
        return lazyMan; // 单线程下ok，多线程下有问题
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 用反射破坏单例
//        LazyMan lazyMan = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true); // 破坏私有权限
        LazyMan lazyMan = declaredConstructor.newInstance();
        LazyMan lazyMan1 = declaredConstructor.newInstance();
        System.out.println(lazyMan);
        System.out.println(lazyMan1);
        //打印结果告诉我们，这两个对象并不一致
        // 反射破坏单例结构，该如何处理呢？ 在构造器中进行判断

        // 如果两个对象都是反射创建的呢？通过增加标志位处理

//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
    }
}
