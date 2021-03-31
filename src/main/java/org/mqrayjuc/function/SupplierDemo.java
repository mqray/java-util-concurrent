package org.mqrayjuc.function;

import java.util.function.Supplier;

/**
 * @author ray
 * Date 2021/3/30
 * Supplier 只有输出参数类型
 */
public class SupplierDemo {

    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 1024;
//            }
//        };
        Supplier supplier = ()->{return 1024;};
        System.out.println(supplier.get());
    }
}
