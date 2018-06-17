package com.wk51920.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: FileNumMonitor
 * @description: 实现言行
 * @author: wk
 * @create: 2018-06-18 00:09
 **/
@Component
public class User {
    private String name;
    private int age;

    public User(@Value("${name}")String name, @Value("${age}") int age) {
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
