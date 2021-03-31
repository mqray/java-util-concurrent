package org.mqrayjuc.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author ray
 * Date 2021/3/30
 * 年龄为偶数
 * 筛选年龄大于23，
 * 名字转为大写
 * 用户名字倒序排列
 * 只能输出一个用户
 */
public class Demo1 {

    public static void main(String[] args) {
        User u1 = new User(1,"mqray1",12);
        User u2 = new User(2,"mqray2",14);
        User u3 = new User(3,"mqray3",23);
        User u4 = new User(4,"mqray4",26);
        User u5 = new User(5,"mqray5",28);
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream()
                .filter((user)->{return user.getAge()%2==0;})
                .filter((user)->{return user.getAge()>23;})
                .map((user)->{return user.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
