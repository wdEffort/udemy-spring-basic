package com.udemy.springbasic.ex07aop.sample03;

public class Staff {

    private String name;
    private int age;
    private String dept;

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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * 스태프 정보 얻어오기
     */
    public void getInfo() {
        System.out.println("학생 이름 : " + getName());
        System.out.println("나이 : " + getAge());
        System.out.println("부서 : " + getDept());
    }
}
