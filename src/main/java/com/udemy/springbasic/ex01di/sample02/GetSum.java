package com.udemy.springbasic.ex01di.sample02;

/**
 * Spring Framework Setter 메소드를 사용한 의존성 주입 테스트를 위한 GetSum 클래스 선언
 */
public class GetSum {

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void sum(int a, int b) {
        System.out.println(String.format("%d + %d = %d", a, b, a + b));
    }
}
