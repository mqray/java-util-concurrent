package org.mqrayjuc.function;

import java.util.function.Function;

/**
 * @author ray
 * Date 2021/3/30
 * 四大函数型接口
 * Function 有一个输入参数，一个输出参数
 */
public class FunctionDemo {

    public static void main(String[] args) {
//        Function function = new Function<String, String>() {
//            @Override
//            public String apply(String o) {
//                return o;
//            }
//        };
//        Function function = (str)->{return str;};
        Function function = str->{return str;};
        System.out.println(function.apply("1234"));
    }
}
