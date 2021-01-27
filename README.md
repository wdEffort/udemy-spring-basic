# Spring Framework

## 개요

1. 스프링 프레임워크는 엔터프라이즈 애플리케이션에서 필요로하는 여러가지 기능을 제공하는 프레임워크이다.
2. J2E가 제공하는 기능들을 스프링에서 지원을 하고 있기 때문에 국내에서는 가장 인기 있는 프레임워크이다.
3. 스프링 프레임워크는 J2E에서 제공하는 기능 외에 DI나 AOP와 같은 기능을 지원한다.

---

## 특징

1. 스프링 프레임워크는 경량형 프레임워크이다.
    - 자바의 객체를 담고 있는 컨테이너이다.
    - 객체의 생성, 소멸과 같은 생명주기를 관리한다.
2. DI(Dependency Injection) 의존성 주입 기능을 지원한다.
    - 설정파일을 통해서 의존관계를 설정해 주는 패턴이다.
3. AOP(Aspect Oriented Programming)을 지원한다.
    - 로깅, 보안, 트랜잭션과 같은 엔터프라이즈 애플리케이션에서 공통으로 필요로 하는 기능을 분리해서 각 모듈에 적용할 수 있도록 하는 기능이다.
4. POJO(Plain Old Java Object)을 지원한다.
    - 특정 인터페이스나 클래스를 상속받지 않는 순수한 자바 객체를 스프링 컨테이너가 가지고 있다.
5. 트랜잭션 처리를 위한 일관된 방식을 지원한다.
6. 영속성과 관련된 다양한 API를 제공한다.
    - JDBC, iBatis, myBatis, JPA, Hibernate 등과 같은 프레임워크와 연동을 지원한다.

---

## 의존성 주입(Dependency Injection, DI)

#### 예제 : package com.udemy.springbasic.ex01di

1. 스프링 프레임워크 핵심 개념중 하나이다.
    - 객체 간 의존관계를 객체 자신이 아닌 외부(스프링 컨테이너)에서 수행하는 개념이다.
    - 의존관계 설정은 설정파일(bean.xml)이나 어노테이션을 이용하여 설정한다.
    ``` java
   /**
    * A 객체에서 B 객체를 생성(A가 B를 가지고 있다. => A는 B에 의존한다.)
    */
    public class A {
        B b = new B();
    
        public void print() {
            b.print();
        }
    }
   
    public class B {
        public void print() {
            System.out.println("Hello");
        }
    }
    /** 
     * Spring Framework DI에서는 의존하는 객체에 대한 획득을 클래스에서 하지 않고, 스프링 컨테이너가 주입해 준다. 
     * 다시 말하면, 개발자는 A 클래스에서 B b = new B(); 할 필요 없이 스프링 컨테이너가 A 클래스를 생성할 때 생성하는 B 클래스의 인스턴스(Bean)을 주입 받는다.
     * 설정은 XML 또는 어노테이션을 통해 이루어진다.
     */
    ```
2. 인터페이스를 이용하여 의존성을 낮춘다.
    - XML 또는 어노테이션 설정만으로 개발자가 원하는 객체의 주입으로 바꿀 수 있다.

---

## 의존성 주입(DI) 종류

#### 예제 : package com.udemy.springbasic.ex01di

1. Setter 메소드를 이용한 주입
    - Setter 메소드를 사용해서 의존성을 주입한다.
2. 생성자(Constructor)를 통한 주입
    - 생성자를 사용해서 의존성을 주입한다.

---

## 의존성 주입(DI)의 장점

#### 예제 : package com.udemy.springbasic.ex01di

1. DI를 사용하면 개발할 때 어느정도 시간이 소요되지만, 큰 규모의 프로젝트에서 유지보수가 용이하다.

---

## 의존 관계 설정 방법

#### 예제 : package com.udemy.springbasic.ex01di

1. XML 설정 파일을 이용한 설정
2. JAVA 소스 코드를 이용한 설정
    - 어노테이션(Metadata, JDK 5 이후 지원)을 이용하여 설정한다. (@Configuration, @Bean, ...)
        1) 컴파일러에게 정보를 알려줄 때
        2) 컴파일 할 때와 설치(Deployment)시의 작업을 지정하거나 실행할 때 별도의 처리가 필요한 경우
        3) 선언시 '@'를 사용하여 선언한다. Ex. @Override, ...
        4) 클래스, 메소드 변수 등 모든 요소에 선언이 가능하다.
    - @Configuration
        1) 클래스 앞에 선언하며 '이 클래스는 스프링 프레임워크 설정에 사용되는 클래스 입니다.'라고 알려주는 어노테이션
    - @Bean
        1) 메소드 앞에 선언, '객체(Bean)를 생성한다.'라고 알려주는 어노테이션
3. XML 설정 파일과 JAVA 소스 코드를 혼용하여 설정
    - XML 설정 파일과 JAVA 설정 파일을 같이 사용해서 설정하는 방법이다.
    - XML 설정 안에 JAVA 설정을 포함시키는 방법과 반대로 JAVA 설정에 XML 설정을 포함시키는 방법 중 한가지를 선택하여 진행한다.

---

## 스프링 컨테이너 생명주기

#### 예제 : package com.udemy.springbasic.ex02lifecycle

1. 스프링 컨테이너 생성 방법
   ```java
   import org.springframework.context.support.GenericXmlApplicationContext;    
   
   public class Main {
   
       public static void main(String[] args) {
           // XML 설정 파일을 읽어오기 위해 GenericXmlApplicationContext 객체 생성
           // => 스프링 컨테이너 생성
           GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
           // XML 설정 파일 Load
           ctx.load("classpath:baseball.xml");
           // refresh() 메소드를 호출함으로써 컨테이너 생성
           ctx.refresh();
   
           // "player" Bean 객체 사용
           Player player = ctx.getBean("player", Player.class);
           System.out.println(player.getName());
           
           // 종료
           ctx.close();
       }
   }  
   ```

---

## Bean Life Cycle(생명주기)

#### 예제 : package com.udemy.springbasic.ex02lifecycle

1. ctx.refresh(); 과정에서 Bean이 생성되며, ctx.close(); 함으로써 컨테이너가 소멸되는 단계에서 Bean도 자동으로 소멸된다.
2. InitializingBean 인터페이스와 DisposableBean 인터페이스를 사용하여 Bean이 생성되거나 소멸될 때 특정 작업을 수행할 수 있다.
    - InitializingBean 인터페이스의 `afterPropertiesSet()` 메소드를 구현하여 Bean이 생성될 때 특정 작업을 선언하여 처리할 수 있다.
    - DisposableBean 인터페이스의 `destroy()` 메소드를 구현하여 Bean이 소멸되기 전에 특정 작업을 선언하여 처리할 수 있다.
    - InitializingBean 인터페이스와 DisposableBean 인터페이스는 필요에 따라 둘 다 사용하거나 하나만 구현해서 사용할 수 있다.
3. 2번 항목의 인터페이스를 사용하는 것 대신 `@PostConstruct` 또는 `@PreDestroy` 어노테이션을 사용해도 된다.

---

## Bean Scope(범위)

#### 예제 : package com.udemy.springbasic.ex03scope

1. 해당 Bean 객체가 어디까지 영향을 미치는지 결정하는 것이다.
2. `<bean/>` 태그의 속성 값
    - singleton(default) : 스프링 컨테이너에 의해 한 개의 Bean 객체만 생성.
    - prototype : Bean을 사용할 때마다 객체를 생성.
    - request : HTTP 요청 마다 Bean 객체를 생성(WebApplicationContext에서만 적용).
    - session : HTTP 세션 마다 Bean 객체를 생성(WebApplicationContext에서만 적용).
    - global-session : 글로벌 HTTP 세션에 대해 Bean 객체를 생성.

---

## 커스텀 초기화 / 소멸 메소드 구현하기

#### 예제 : package com.udemy.springbasic.ex04custom

1. XML 설정 파일을 사용하는 경우 bean 태그 선언시 `init-method`, `destroy-method` 속성을 설정하여 Bean 객체의 생성과 소멸 시에 특정 작업을 실행시킬 수 있다.
    - init-method : 커스텀 초기화 메소드를 지정하는 bean 태그의 속성
    - destroy-method : 커스텀 소멸 메소드를 지정하는 bean 태그의 속성
2. `BeanNameAware` 인터페이스
    - Bean 객체가 자기자신의 이름을 알아야 할 경우 사용된다.
    - 클래스가 BeanNameAware 인터페이스를 구현한 경우 컨테이너는 setBeanName() 메소드를 호출해서 Bean 객체의 이름을 전달한다.
        1) setBeanName(String arg) : Bean 객체가 생성될 때 해당 객체의 id나 name 값을 전달 받는 메소드

---

## 외부 파일을 이용한 Bean 설정

#### 예제 : package com.udemy.springbasic.ex05environment

1. EnvironmentAware 인터페이스를 활용
    - 외부 파일을 이용하기 위해 Environment 객체를 얻는 방법
        1) Context : Context 객체를 생성한 후 getEnvironment() 메소드를 사용하여 Environment 객체를 얻어 온다.
        2) Environment : Environment 객체를 생성한 후 getPropertySources() 메소드를 사용하여 PropertySources 객체를 얻어 온다.
        3) PropertySources : PropertySources 객체를 생성한 후 추가(addLast)하거나, 추출(getProperty)하는 작업을 할 수 있다.
2. XML 설정 파일에 외부 properties 파일을 명시하는 방법
    - XML 설정 파일에서 외부 properties 파일을 불러오기 위해서는 `<context:property-placeholder location="설정파일"/>` 태그를 사용해야 한다.
        1) 단, 여러 개의 외부 properties 파일을 사용할 때에는 꼭 파일명 앞에 "classpath:"를 명시해 주어야 한다.
            ```xml
           <?xml version="1.0" encoding="UTF-8"?>
            <beans xmlns="http://www.springframework.org/schema/beans"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xmlns:context="http://www.springframework.org/schema/context"
                   xsi:schemaLocation="http://www.springframework.org/schema/beans
                                       http://www.springframework.org/schema/beans/spring-beans.xsd
                                       http://www.springframework.org/schema/context
                                       http://www.springframework.org/schema/context/spring-context.xsd">

                <context:property-placeholder location="classpath:env.properties, classpath:external.properties"/>
            
                <bean id="ext" class="com.udemy.springbasic.ex05environment.sample02.ExternalFileEx">
                    <property name="id">
                        <value>${env.id}</value>
                    </property>
                    <property name="pw">
                        <value>${env.pw}</value>
                    </property>
                    <property name="extId" value="${ext.id}"/>
                    <property name="extPw" value="${ext.pw}"/>
                </bean>
            
            </beans>
            ```
3. Java 설정 파일에 외부 properties 파일을 명시하는 방법
    - Java 설정 파일에서 외부 properties 파일을 불러오기 위해서는 `PropertySourcesPlaceholderConfigurer` 객체를 생성한 후 외부 properties 파일을 등록해 주어야 한다.