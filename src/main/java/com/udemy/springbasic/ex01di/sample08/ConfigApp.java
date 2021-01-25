package com.udemy.springbasic.ex01di.sample08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ConfigApp {

    /**
     * 'player03' Bean 객체 생성
     * 1. XML 설정 파일 <bean/> 태그의 id 속성(Bean 이름)이 자바 설정에서는 메소드의 이름이 된다.
     * 2. XML 설정 파일 <bean/> 태그의 class 속성(Bean 타입)이 자바 설정에서는 메소드의 리턴 타입이 된다.
     *
     * @return
     */
    @Bean
    public Player player03() {
        ArrayList<String> position = new ArrayList<>();
        position.add("7번");
        position.add("2루수");

        Player player = new Player("박중호", 28, position);
        player.setHeight(179.1);
        player.setWeight(85.3);

        return player;
    }
}
