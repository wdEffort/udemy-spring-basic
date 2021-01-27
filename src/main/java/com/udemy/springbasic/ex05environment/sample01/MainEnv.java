package com.udemy.springbasic.ex05environment.sample01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class MainEnv {

    public static void main(String[] args) throws IOException {
        // Environment 객체를 생성하기 위해 ConfigurableApplicationContext를 사용한다.
        ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = ctx.getEnvironment(); // Context 객체에서 Environment 객체를 얻는다.
        MutablePropertySources propertySources = environment.getPropertySources(); // Environment 객체에서 PropertySources 객체를 얻는다.

        // Environment는 여러 property들을 가지고 있는데, 추가적인 property가 필요한 경우
        // PropertySources 객체의 addLast() 메소드를 사용하여 외부 파일(.properties)에서 새로운 property를 가져와서 추가해준다.
        propertySources.addLast(new ResourcePropertySource("classpath:env.properties"));

        System.out.println(environment.getProperty("env.id")); // env.properties 파일에 설정된 id 값을 가져옴
        System.out.println(environment.getProperty("env.pw")); // env.properties 파일에 설정된 pw 값을 가져옴

        // env Bean 객체를 가져오기 위한 처리
        GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
        gCtx.load("classpath:env-context.xml");
        gCtx.refresh();

        EnvironmentEx environmentEx = gCtx.getBean("env", EnvironmentEx.class);
        System.out.println(environmentEx.getId());
        System.out.println(environmentEx.getPw());

        gCtx.close();
        ctx.close();
    }
}
