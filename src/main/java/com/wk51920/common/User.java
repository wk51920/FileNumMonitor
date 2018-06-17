package com.wk51920.common;

/**
 * @program: FileNumMonitor
 * @description: 实现言行
 * @author: wk
 * @create: 2018-06-18 00:09
 **/
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
