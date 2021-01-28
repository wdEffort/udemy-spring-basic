package com.udemy.springbasic.ex06profile.sample02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production") // Profile 속성을 사용하여 개발 환경과 운영 환경에서의 설정을 분리한다.
@Import({JndiDataConfig.class, StandaloneDataConfig.class})
public class ProdConfig {

    /**
     * Java 설정 파일을 사용하여 ProfileEx Bean 객체를 "profileEx"라는 이름으로 생성
     *
     * @return
     */
    @Bean
    public ProfileEx profileEx(Person person) {
        ProfileEx prof = new ProfileEx();
        prof.setIp("210.95.68.122");
        prof.setPort("80");
        prof.setPerson(person);

        return prof;
    }
}
