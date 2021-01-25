package com.udemy.springbasic.ex04custom.sample01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainLifeBean {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:lifebean-context.xml");

        LifeBean lifeBean = ctx.getBean("lifeBean", LifeBeanImpl.class);
        lifeBean.lifeMethod();

        ctx.close();

    }
}
