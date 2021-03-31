package org.mqrayjuc.function;

import java.util.function.Consumer;

/**
 * @author ray
 * Date 2021/3/30
 * 四大函数型接口
 * Consumer 只有输入没有输出
 */
public class ConsumerDemo {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("1234");
    }
}
