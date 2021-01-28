package com.udemy.springbasic.ex07aop.sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/aop02-context.xml");

        Service service = (Service) ctx.getBean("service");
        service.addBoard();
        service.getBoard();
        service.delBoard();
    }
}
