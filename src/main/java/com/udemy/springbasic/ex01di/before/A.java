package com.udemy.springbasic.ex01di.before;

/**
 * Spring Framework DI 사용 전 예제를 위한 클래스 A 선언
 */
public class A {

    B b = new B();

    public void print() {
        b.print();
    }
}
