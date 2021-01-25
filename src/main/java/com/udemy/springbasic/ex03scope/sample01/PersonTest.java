package com.udemy.springbasic.ex03scope.sample01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonTest {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person-context.xml");
        Person person1 = ctx.getBean("person", Person.class);
        System.out.println("pserson1 : " + person1);
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println();

        Person person2 = ctx.getBean("person", Person.class);
        person2.setName("홍길동");
        System.out.println("person2 : " + person2);
        System.out.println(person2.getName());
        System.out.println(person2.getAge());
        System.out.println();

        if (person1.equals(person2)) {
            System.out.println("person1 == person2");
        } else {
            System.out.println("person1 != person2");
        }

        System.out.println();

        System.out.println("person1 name : " + person1.getName());

        ctx.close();
    }
}
