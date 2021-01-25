package com.udemy.springbasic.ex01di.sample06;

public class HyundaiCar implements Car {

    @Override
    public void drive() {
        System.out.println("현대 자동차를 운전합니다.");
    }
}
