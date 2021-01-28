package com.udemy.springbasic.ex07aop.sample02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * 모든 비즈니스 로직(= 핵심 기능) 메소드가 가지는 공통 기능을 구현한 클래스
 * 로깅
 */
public class LoggingAdvice {

    /**
     * 스프링으로 부터 method, target, 매개변수 등의 정보를 가진 JoinPoint 객체를 전달 받는다.
     * 즉, 매개변수 선언만 해놓으면 가져다 사용할 수 있다.
     *
     * @param joinPoint
     */
    public void logging(JoinPoint joinPoint) {
        Signature method = joinPoint.getSignature(); // 핵심 기능을 실행하는 메소드 정보 조회
        String methodName = method.getName(); // 메소드명

        System.out.println("[LOG] Call method name : " + methodName);
    }
}
