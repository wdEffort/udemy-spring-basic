package com.udemy.springbasic.ex01di.sample04;

public class PersonInfo {

    private Person person;

    public PersonInfo() {
    }

    public PersonInfo(Person person) {
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void getPersonInfo() {
        if (this.person != null) {
            System.out.println("아이디 : " + this.person.getId());
            System.out.println("이름 : " + this.person.getName());
            System.out.println("성별 : " + this.person.getGender());
            System.out.println("나이 : " + this.person.getAge());
        }
    }
}
