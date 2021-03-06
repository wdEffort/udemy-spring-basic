package com.udemy.springbasic.ex06profile.sample01;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Scanner;

public class MainProfile {

    public static void main(String[] args) {
        String profile = null;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        if (str.equals("development")) {
            profile = "development";
        } else if (str.equals("production")) {
            profile = "production";
        }

        scanner.close();

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        // development, production 설정 파일 중 무엇을 사용할지 결정지을 수 있게 setActiveProfiles() 메소드를 사용한다.
        ctx.getEnvironment().setActiveProfiles(profile);
        // XML 설정 파일 등록
        ctx.load("development-context.xml", "production-context.xml");
        ctx.refresh();

        ProfileEx prof = ctx.getBean("profileEx", ProfileEx.class);

        System.out.println("ip : " + prof.getIp());
        System.out.println("port : " + prof.getPort());

        ctx.close();
    }
}
