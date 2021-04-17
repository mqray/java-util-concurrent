package org.mqrayreflect;

import lombok.Data;

/**
 * @author ray
 * Date 2021/4/17
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        System.out.println(student.name);

        // 方法一 通过对象获得
        Class<? extends Student> c1 = student.getClass();
        System.out.println(c1.hashCode());

        // 方法二 forName获得
        Class<?> c2 = Class.forName("org.mqrayreflect.Student");
        System.out.println(c2.hashCode());

        // 方法三 通过类名.class获得
        Class<Student> c3 = Student.class;
        System.out.println(c3.hashCode());

        // 方法四 基本类型的包装类都有一个Type属性
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

        // 获得父类类型
        Class<?> superclass = c1.getSuperclass();
        System.out.println(superclass);
    }

}

@Data
class Person {

    public String name;

    public Person() {
    }

    public Person(String name) {
    }
}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}
