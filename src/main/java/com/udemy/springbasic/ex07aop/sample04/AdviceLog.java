package com.udemy.springbasic.ex07aop.sample04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 모든 비즈니스 로직(= 핵심 기능) 메소드가 가지는 공통 기능을 구현한 클래스
 */
@Aspect
public class AdviceLog {

    /**
     * "@Pointcut" 어노테이션을 이용하여 Point-cut 설정
     * within 또는 execution을 사용하여 Advice를 적용할 대상을 설정한다.
     */
    //@Pointcut("within(com.udemy.springbasic.ex07aop.sample04.*)") // Point-cut 지정
    @Pointcut("execution(* com.udemy.springbasic.ex07aop.sample04.*.*())")
    private void pointcutMethod() {
    }

    /**
     * 메소드 실행 시간을 측정하는 Advice
     * 실제로는 Code + Advice 구조로 이루어 진다.
     *
     * @param proceedingJoinPoint ProceedingJoinPoint 객체는 원래 실행되어야 할 대상 메소드(핵심 기능)를 가르킨다.
     * @return
     * @throws Throwable
     */
    @Around("pointcutMethod()")
    // "@Around" 어노테이션을 사용하여 Around Advice를 설정한다. 이때 어노테이션에 설정된 메소드는 Point-cut을 가리키며, 이는 결국 Advice가 적용될 대상 메소드를 의미한다.
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
        }
    }

    /**
     * 핵심 기능이 실행되기 전에 Advice를 실행
     */
    //@Before("within(com.udemy.springbasic.ex07aop.sample04.*)")
    @Before("pointcutMethod()")
    public void beforeAdvice() {

        System.out.println("beforeAdvice() ...");
    }

    /**
     * 정상적으로 핵심 기능이 실행된 후 Advice를 실행
     */
    //@AfterReturning("within(com.udemy.springbasic.ex07aop.sample04.*)")
    @AfterReturning("pointcutMethod()")
    public void afterReturningAdvice() {
        System.out.println("afterReturningAdvice() ...");
    }

    /**
     * 핵심 기능 실행 중 Exception이 발생하면 Advice를 실행
     */
    //@AfterThrowing("within(com.udemy.springbasic.ex07aop.sample04.*)")
    @AfterThrowing("pointcutMethod()")
    public void afterThrowingAdvice() {
        System.out.println("afterThrowingAdvice() ...");
    }

    /**
     * 핵심 기능 실행 후에 Advice를 실행(Exception이 발생하더라도 ...)
     */
    //@After("within(com.udemy.springbasic.ex07aop.sample04.*)")
    @After("pointcutMethod()")
    public void afterAdvice() {
        System.out.println("afterAdvice() ...");
    }
}
