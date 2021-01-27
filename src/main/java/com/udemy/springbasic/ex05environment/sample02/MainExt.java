package com.udemy.springbasic.ex05environment.sample02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExt {

    public static void main(String[] args) {
        // XML 설정 파일을 읽어 올 때에는 GenericXmlApplicationContext를 사용한다.
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:ext-context.xml");
        ExternalFileEx ext = ctx.getBean("ext", ExternalFileEx.class);
        System.out.println("env.id : " + ext.getId());
        System.out.println("env.pw : " + ext.getPw());
        System.out.println("ext.id : " + ext.getExtId());
        System.out.println("ext.pw : " + ext.getExtPw());

        ctx.close();
    }
}
