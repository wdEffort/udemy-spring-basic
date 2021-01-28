package com.udemy.springbasic.ex07aop.sample02;

public class ServiceImpl implements Service {

    @Override
    public void getBoard() {
        System.out.println("(Progress) ServiceImpl.getBoard() ...");
    }

    @Override
    public void addBoard() {
        System.out.println("(Progress) ServiceImpl.addBoard() ...");
    }

    @Override
    public void delBoard() {
        System.out.println("(Progress) ServiceImpl.delBoard() ...");
    }
}
