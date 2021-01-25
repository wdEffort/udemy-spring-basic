package com.udemy.springbasic.ex04custom.sample01;

import org.springframework.beans.factory.BeanNameAware;

public class LifeBeanImpl implements LifeBean, BeanNameAware {

    private String beanName; // 설정 파일에서 bean의 id를 저장하기 위한 변수

    @Override
    public void lifeMethod() {
        System.out.println("비즈니스 로직을 수행 ...");
        System.out.println("Bean name : " + this.beanName);
    }

    /**
     * 커스텀 초기화 메소드
     */
    public void init() {
        System.out.println("사용자 초기화 메소드 호출 ...");
    }

    /**
     * 커스텀 소멸 메소드
     */
    public void destroy() {
        System.out.println("사용자 소멸 메소드 호출 ...");
    }

    /**
     * BeanNameAware 인터페이스의 메소드를 구현
     * Bean 객체가 자신의 이름을 알아야 하는 경우 사용하는 메소드.
     * Bean 객체가 생성될 때 해당 객체의 id 값을 전달 받는다.
     *
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
