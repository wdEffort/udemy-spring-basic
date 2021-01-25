package com.udemy.springbasic.ex02lifecycle.sample01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Player implements InitializingBean, DisposableBean {

    private String name;
    private int age;

    public Player() {
    }

    public Player(String name, int age) {
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

    /**
     * InitializingBean 인터페이스의 afterPropertiesSet() 메소드를 오버라이딩 하여
     * Bean 생성시 처리할 작업들을 선언하여 처리할 수 있다.
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("인터페이스 구현: Bean 생성시 처리할 작업들 ...");
    }

    /**
     * DisposableBean 인터페이스의 destory() 메소드를 오버라이딩 하여
     * Bean 소멸시 처리할 작업들을 선언하여 처리할 수 있다.
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("인터페이스 구현: Bean 소멸시 처리할 작업들 ...");
    }
}
