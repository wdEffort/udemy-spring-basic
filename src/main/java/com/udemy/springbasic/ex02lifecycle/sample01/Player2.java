package com.udemy.springbasic.ex02lifecycle.sample01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Player2 {

    private String name;
    private int age;

    public Player2() {
    }

    public Player2(String name, int age) {
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

    @PostConstruct
    public void init() {
        System.out.println("어노테이션: Bean 생성시 처리할 작업들 ...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("어노테이션: Bean 소멸시 처리할 작업들 ...");
    }
}
