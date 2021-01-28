package com.udemy.springbasic.ex07aop.sample02;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 모든 비즈니스 로직(= 핵심 기능) 메소드가 가지는 공통 기능을 구현한 클래스
 * 실행 시간 측정
 * 핵심 기능 대상 메소드를 실행할 수 있는 기능을 가진 ProceedingJoinPoint를 전달 받는다. (Around)
 */
public class TimeCheckAdvice {

    /**
     * @param proceedingJoinPoint
     * @return 핵심 기능 실행 메소드의 실행 반환값
     * @throws Throwable
     */
    public Object check(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Method start ...");

        // proceed() 메소드를 호출하지 않으면 비즈니스 로직(= 핵심 기능)을 수행할 수 없다.
        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("Method end ...");
        System.out.println();

        // 핵심 기능 대상 메소드의 실행 결과로 얻어진 값을 반환해야 한다.
        return returnValue;
    }
}
