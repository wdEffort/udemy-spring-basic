package com.udemy.springbasic.ex01di.sample01;

/**
 * Spring Framework 인터페이스를 사용하여 의존성을 낮추는 방법을 테스트하기 위한 Dao 인터페이스의 구현체인 DaoImpl 선언
 */
public class DaoImpl implements Dao {

    @Override
    public void print() {
        System.out.println("Hello");
    }
}
