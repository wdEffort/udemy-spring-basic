package com.udemy.springbasic;

import com.udemy.springbasic.ex01di.sample07.ConfigApp;
import com.udemy.springbasic.ex01di.sample07.Player;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main02 {

    public static void main(String[] args) {
        // Java 설정 파일을 읽어 올 때에는 AnnotationConfigApplicationContext를 사용한다.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);

        Player player03 = ctx.getBean("player03", Player.class);
        System.out.println("선수 이름: " + player03.getName());
        System.out.println("나이: " + player03.getAge());
        System.out.println("포지션: " + player03.getPosition());
        System.out.println("신장: " + player03.getHeight());
        System.out.println("몸무게: " + player03.getWeight());
        System.out.println();

        Player player04 = ctx.getBean("player04", Player.class);
        System.out.println("선수 이름: " + player04.getName());
        System.out.println("나이: " + player04.getAge());
        System.out.println("포지션: " + player04.getPosition());
        System.out.println("신장: " + player04.getHeight());
        System.out.println("몸무게: " + player04.getWeight());
        System.out.println();

        ctx.close();
    }
}
