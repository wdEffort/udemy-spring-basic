package com.udemy.springbasic.ex01di.sample03;

/**
 * Spring Framework 생성자를 사용한 의존성 주입 테스트를 위한 ExDao 클래스 선언
 */
public class ExDao {

    private String message;

    public ExDao() {
    }

    public ExDao(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println("message : " + message);
    }
}
