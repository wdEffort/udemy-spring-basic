package com.udemy.springbasic.ex01di.sample02;

/**
 * Spring Framework Setter 메소드를 사용한 의존성 주입 테스트를 위한 MyGetSum 클래스 선언
 */
public class MyGetSum {

    private int a;
    private int b;
    GetSum getSum;

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

    public GetSum getGetSum() {
        return getSum;
    }

    public void setGetSum(GetSum getSum) {
        this.getSum = getSum;
    }

    public void sum() {
        getSum.sum(this.a, this.b);
    }
}
