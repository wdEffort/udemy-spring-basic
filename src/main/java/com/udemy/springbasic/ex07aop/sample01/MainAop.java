package com.udemy.springbasic.ex07aop.sample01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAop {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop-context.xml");

        Student student = ctx.getBean("student", Student.class);
        student.getInfo();

        Staff staff = ctx.getBean("staff", Staff.class);
        staff.getInfo();

        ctx.close();
    }
}
