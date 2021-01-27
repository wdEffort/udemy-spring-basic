package com.udemy.springbasic.ex05environment.sample02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExt2 {

    public static void main(String[] args) {
        // Java 설정 파일을 읽어 올 때에는 AnnotationConfigApplicationContext를 사용한다.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExtConfig.class);
        ExternalFileEx ext = ctx.getBean("extConf", ExternalFileEx.class);
        System.out.println("env.id : " + ext.getId());
        System.out.println("env.pw : " + ext.getPw());
        System.out.println("ext.id : " + ext.getExtId());
        System.out.println("ext.pw : " + ext.getExtPw());

        ctx.close();
    }
}
