package com.udemy.springbasic.ex01di.sample09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainBaseball {

    public static void main(String[] args) {
        // Java 설정 파일을 읽어 올 때에는 AnnotationConfigApplicationContext를 사용한다.
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);

        Player player01 = ctx.getBean("player10", Player.class);
        System.out.println(player01.getName());
        System.out.println(player01.getAge());
        System.out.println(player01.getPosition());
        System.out.println(player01.getHeight());
        System.out.println(player01.getWeight());
        System.out.println();

        Player player03 = ctx.getBean("player11", Player.class);
        System.out.println(player03.getName());
        System.out.println(player03.getAge());
        System.out.println(player03.getPosition());
        System.out.println(player03.getHeight());
        System.out.println(player03.getWeight());
        System.out.println();

        ctx.close();
    }

}
