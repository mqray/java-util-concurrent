package org.mqrayjuc.singleton;

/**
 * @author ray
 * Date 2021/3/31
 * 反射不能破坏枚举
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) {
        EnumSingle e1 = EnumSingle.INSTANCE;
        EnumSingle e2 = EnumSingle.INSTANCE;
        System.out.println(e1);
        System.out.println(e2);
    }
}

