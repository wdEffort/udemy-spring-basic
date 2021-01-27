package com.udemy.springbasic.ex05environment.sample02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class ExtConfig {

    // @Value 어노테이션을 사용하면 외부 properties 파일에 선언된 프로퍼티 값을 가져올 수 있다.
    @Value("${env.id}")
    private String envId;
    @Value("${env.pw}")
    private String envPw;
    @Value("${ext.id}")
    private String extId;
    @Value("${ext.pw}")
    private String extPw;

    /**
     * Java 설정 파일에서 외부 properties 파일을 읽기 위해 PropertySourcesPlaceholderConfigurer Bean 객체를 "Properties"라는 이름으로 생성
     * - Bean 객체를 생성과 동시에 미리 메모리에 올려 놓기 위해 static으로 선언
     * - "Properties" 객체는 시스템에서 자동으로 호출해 준다.(=> 스프링 컨테이너에서 호출해서 사용하는 메소드)
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer Properties() {
        // 외부 properties 파일의 위치 값을 저장하는 객체를 생성
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        // 여러 외부 properties 파일을 가져오기 위한 Resource 객체 배열을 생성한다.
        Resource[] locations = new Resource[2];
        locations[0] = new ClassPathResource("env.properties");
        locations[1] = new ClassPathResource("external.properties");

        configurer.setLocations(locations);

        return configurer;
    }

    /**
     * ExternalFileEx Bean 객체를 "extConf"라는 이름으로 생성
     * - (주의) 만약, extConfig라고 이름을 사용하게 되면 Java 설정 파일 이름과 동일해서 에러가 날 수 있음.
     *
     * @return
     */
    @Bean
    public ExternalFileEx extConf() {
        ExternalFileEx ext = new ExternalFileEx();
        ext.setId(envId);
        ext.setPw(envPw);
        ext.setExtId(extId);
        ext.setExtPw(extPw);

        return ext;
    }
}
