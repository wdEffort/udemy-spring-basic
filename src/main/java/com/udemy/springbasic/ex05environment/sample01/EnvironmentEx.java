package com.udemy.springbasic.ex05environment.sample01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvironmentEx implements EnvironmentAware, InitializingBean, DisposableBean {

    private Environment environment;
    private String id;
    private String pw;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment() 메소드 호출 ...");
        this.environment = environment;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() 메소드 호출 ...");
        setId(this.environment.getProperty("env.id"));
        setPw(this.environment.getProperty("env.pw"));
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() 메소드 호출 ...");
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
