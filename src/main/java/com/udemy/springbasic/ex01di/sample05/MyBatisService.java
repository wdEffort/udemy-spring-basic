package com.udemy.springbasic.ex01di.sample05;

public class MyBatisService {

    private MyBatisDao myBatisDao;

    public void setMyBatisDao(MyBatisDao myBatisDao) {
        this.myBatisDao = myBatisDao;
    }

    public void myBatisTest() {
        myBatisDao.insert();
        myBatisDao.update();
    }
}
