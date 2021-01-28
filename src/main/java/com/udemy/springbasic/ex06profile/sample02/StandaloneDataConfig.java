package com.udemy.springbasic.ex06profile.sample02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class StandaloneDataConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("홍길동");
        person.setAge(30);

        return person;
    }
}
