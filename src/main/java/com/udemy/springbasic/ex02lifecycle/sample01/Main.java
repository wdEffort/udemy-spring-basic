package com.udemy.springbasic.ex02lifecycle.sample01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:baseballteam04-context.xml");
        ctx.refresh();
        ctx.close();
    }
}
