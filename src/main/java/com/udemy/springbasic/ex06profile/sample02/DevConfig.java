package com.udemy.springbasic.ex06profile.sample02;

import com.udemy.springbasic.ex06profile.sample01.ProfileEx;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") // Profile 속성을 사용하여 개발 환경과 운영 환경에서의 설정을 분리한다.
public class DevConfig {

    /**
     * Java 설정 파일을 사용하여 ProfileEx Bean 객체를 "profileEx"라는 이름으로 생성
     *
     * @return
     */
    @Bean
    public ProfileEx profileEx() {
        ProfileEx prof = new ProfileEx();
        prof.setIp("127.0.0.1");
        prof.setPort("8000");

        return prof;
    }
}
