package com.udemy.springbasic.ex05environment.sample02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExternalFileEx implements InitializingBean, DisposableBean {

    private String id;
    private String pw;
    private String extId;
    private String extPw;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() 메소드 호출 ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() 메소드 호출 ...");
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

    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    public String getExtPw() {
        return extPw;
    }

    public void setExtPw(String extPw) {
        this.extPw = extPw;
    }
}
