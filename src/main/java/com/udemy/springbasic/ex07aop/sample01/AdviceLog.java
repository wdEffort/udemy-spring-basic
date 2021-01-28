package com.udemy.springbasic.ex07aop.sample01;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 모든 비즈니스 로직(= 핵심 기능) 메소드가 가지는 공통 기능을 구현한 클래스
 */
public class AdviceLog {

    /**
     * 메소드 실행 시간을 측정하는 Advice
     * 실제로는 Code + Advice 구조로 이루어 진다.
     *
     * @param proceedingJoinPoint ProceedingJoinPoint 객체는 원래 실행되어야 할 대상 메소드(핵심 기능)를 가르킨다.
     * @return
     * @throws Throwable
     */
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 어떠한 메소드가 실행되었는지 조회
        String signStr = proceedingJoinPoint.getSignature().toShortString();

        System.out.println(signStr + " is start ...");

        long startTime = System.currentTimeMillis();

        try {
            Object obj = proceedingJoinPoint.proceed(); // 핵심 기능(Code) 실행
            return obj;
        } finally {
            long endTime = System.currentTimeMillis();

            System.out.println(signStr + " is finished ...");
            System.out.println(signStr + " 경과 시간 : " + (endTime - startTime));
            System.out.println();
        }
    }
}
