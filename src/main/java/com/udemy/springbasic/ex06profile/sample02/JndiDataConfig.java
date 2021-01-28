package com.udemy.springbasic.ex06profile.sample02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class JndiDataConfig {

    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("김철수");
        person.setAge(29);

        return person;
    }
}
