package org.mqrayjuc.function;

import java.util.function.Predicate;

/**
 * @author ray
 * Date 2021/3/30
 * 四大函数型接口
 * Predicate
 * 断定型接口，返回值是布尔值
 */
public class PredicateDemo {

    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test("asd"));
    }
}
