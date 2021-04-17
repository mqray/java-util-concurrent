package org.mqrayreflect;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ray
 * Date 2021/4/17
 */
public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("org.mqrayreflect.User");
        System.out.println(aClass);
        aClass.newInstance();
    }
}

//@Getter
//@Setter
@Data
class User{

    private String name;

    private int age;

    private int id;

//    public User(){};
//
//    public User(String name, int id, int age){
//        this.name = name;
//        this.id = id;
//        this.age = age;
//    }
}

