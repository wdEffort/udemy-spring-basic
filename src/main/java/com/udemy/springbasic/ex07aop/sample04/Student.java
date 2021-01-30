package com.udemy.springbasic.ex07aop.sample04;

public class Student {

    private String name;
    private int age;
    private String hakbun;
    private String grade;

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

    public String getHakbun() {
        return hakbun;
    }

    public void setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 학생 정보 얻어오기
     */
    public void getInfo() {
        System.out.println("학생 이름 : " + getName());
        System.out.println("학번 : " + getHakbun());
        System.out.println("나이 : " + getAge());
        System.out.println("학년 : " + getGrade());

        // after-throwing 테스트를 위해 예외 발생시키기
        // System.out.println(10 / 0);
    }
}
