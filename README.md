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
    - Java 설정 파일에서 외부 properties 파일을 불러오기 위해서는 `PropertySourcesPlaceholderConfigurer` 객체를 생성한 후 외부 properties 파일을 등록해
      주어야 한다.

---

## Profile 속성을 이용한 Bean 설정

#### 예제 : package com.udemy.springbasic.ex06profile

1. 개발 환경과 운영 환경에서의 설정을 분리하고 싶을 때
    - XML 설정 파일을 이용한 개발 환경, 운영 환경에서의 설정 분리
        1) XML 설정에서 `profile="development"`와 같이 속성을 설정한다.
    - Java 설정 파일을 이용한 개발 환경, 운영 환경에서의 설정 분리
        1) Java 설정에서 `@Profile("development")`와 같이 어노테이션을 사용한다.

---

## IoC(Inversion of Control, 제어의 역전)란?

1. IoC란 프로그램의 제어 흐름 구조가 바뀌는 것을 뜻한다.
    - 일반적인 프로그램의 흐름 구조는 main()과 같은 프로그램이 시작되는 지점에서 사용할 객체(Object)를 결정 및 생성하고, 생성된 객체의 메소드를 호출하는 작업을 반복한다. 즉, 모든 종류의 작업을
      사용하는 쪽에서 제어하는 구조다.
    - IoC는 제어 흐름의 개념을 거꾸로 뒤집는 개념이다. 객체는 자신이 사용할 객체를 스스로 생성하거나 선택하지 않는다. 즉, 모든 제어 권한을 자신이 아닌 다른 대상에게 위임한다.
        1) 프로그램의 시작을 담당하는 main()과 같은 `엔트리 포인트`를 제외하면 모든 객체는 제어 권한을 위임받은 특별한 객체에 의해 결정되고 만들어 진다.
        2) 객체는 자신이 어떻게 생성되고 어떻게 사용되는지 알 수 없다.
2. IoC 구현 방법
    - DL(Dependency Lookup, 의존성 검색) : 저장소에 저장되어 있는 Bean에 접근하기 위해서 개발자들이 컨테이너에서 제공하는 API를 이용하여 Bean을 Lookup하는 것.
    - DI(Dependency Injection, 의존성 주입) : DL을 사용할 때에는 컨테이너에 대한 종속성이 증가하기 때문에 이러한 종속성을 줄이기 위해 DI를 사용한다. 각 계층 사이, 각 객체(클래스)
      사이의 필요로 하는 의존 관계를 컨테이너가 자동으로 연결해 주는 것.
        1) 각 클래스 사이의 의존 관계를 Bean 설정(Bean Definition) 정보를 바탕으로 컨테이너가 자동으로 연결해 주는 것
            - Setter Injection
            - Constructor Injection
3. IoC 용어 정리
    - Bean : 스프링에서 제어권을 가지고 직접 만들고 관계를 부여하는 객체(Object)
        1) Java Bean, EJB의 Bean과 비슷한 객체(Object) 단위의 어플리케이션 컴포넌트를 의미.
        2) 스프링 Bean은 스프링 컨테이너가 생성, 관계 설정, 사용 등을 제어해주는 객체를 가리킨다.
    - Bean Factory : 스프링 IoC를 담당하는 핵심 컨테이너
        1) Bean을 등록, 생성, 조회, 반환, 관리한다.
        2) Bean Factory를 바로 사용하지 않고 이를 확장한 Application Context를 이용한다.
        3) BeanFactory는 Bean Factory가 구현하는 인터페이스이다.
            - getBean() 메소드 정의
    - Application Context : Bean Factory를 확장한 IoC 컨테이너
        1) Bean 등록, 생성, 조회, 반환, 관리 기능과 함께 스프링의 각종 부가 서비스를 추가로 제공한다.
        2) ApplicationContext는 인터페이스이며 BeanFactory를 상속한다.
    - Configuration Metadata : 설정 정보(설정 메타 정보)
        1) Application Context 혹은 Bean Factory가 IoC를 적용하기 위해 사용하는 메타 정보
        2) 스프링의 설정 정보는 컨테이너에 어떤 기능을 설정하거나 조정하는 경우에 사용되기도 하고, 주로 Bean을 생성, 구성하는 용도로 사용된다.
    - Container(IoC Container) : IoC 방식으로 Bean을 관리한다는 의미에서 Bean Factory나 Application Context를 가리킨다.
        1) Spring Container == Application Context
        2) Application Context는 그 자체로는 ApplicationContext 인터페이스를 구현한 객체(Object)를 의미한다.
        3) 하나의 어플리케이션에서는 보통 여러 개의 ApplicationContext 객체(Object)가 만들어지며, 이를 통칭해서 Spring Container라고 부른다.
        4) 즉, 객체를 관리하는 컨테이너이다.
    - Spring Framework : IoC Container, Application Context를 포함해서 스프링에서 제공하는 모든 기능을 통칭한다.

---

## AOP(Aspect Oriented Programming, 관점 지향 프로그래밍)

1. 기존 OOP를 보완한 개념이다.
    - 핵심 관심 사항과 공통 관심 사항을 분리하여 구현한다.
        1) 핵심 관심 사항(Primary(또는 Core) concern) : 비즈니스 로직 = 주 업무
            - 단, 비즈니스 로직은 Primary + Cross-cutting도 될 수 있다.
        2) 횡단(공통) 관심 사항(Cross-cutting concern) : 부가 기능 = 보조 업무
2. AOP는 Primary concern과 Cross-cutting concern을 별도의 코드로 분리하여 구현하고 최종적으로 이 둘을 조합해서 완성한다.
3. 주요 용어
    - Code : Primary concern을 구현한 코드
    - Target : Primary concern이 구현된 객체
    - Advice : Cross-cutting concern을 구현한 코드
    - JointPoint : Code와 Advice를 연결해 주는 설정 정보, Advice가 적용 가능한 지점(메소드 호출, 필드값 변경)
    - Point-cut : JointPoint의 부분집합으로서 실제 Advice가 적용되는 JointPoint(JointPoint의 한 부분)
    - Weaving : Code와 Advice, Point-cut 등을 조합해서 어플리케이션을 만들어가는 과정
4. 스프링은 자체적인 프록시(Proxy) 기반의 AOP를 지원한다.
    - 필드값 변경과 같은 JointPoint를 사용할 수 없다.
    - 메소드 호출 JointPoint만 지원한다.
5. 스프링 AOP는 완전한 AOP를 지원하는 것이 목적이 아니라 엔터프라이즈 어플리케이션을 구현하는데 필요한 정도의 기능을 제공한다.

---

## AOP의 Aspect

1. AOP의 Aspect는 `Advice + Point-cut`을 지칭하는 단어이다.

## AOP 구현 방법

1. 설정 파일을 이용하는 방법
    - XML 설정 파일을 이용하는 방법
        1) pom.xml 파일을 이용한 의존 설정
            ```xml
           <!-- AOP -->
           <dependency>
               <groupId>org.aspectj</groupId>
               <artifactId>aspectjweaver</artifactId>
               <version>1.9.5</version>
           </dependency>
            ```
        2) 공통기능 클래스 제작(Advice 역할의 클래스)
        3) XML 설정 파일에서 Aspect 설정
    - XML 설정 파일에서 AOP Advice 종류
        1) `<aop:before>` : 핵심 기능이 실행되기 전에 Advice를 실행
        2) `<aop:after-returning>` : 정상적으로 핵심 기능이 실행된 후 Advice를 실행
        3) `<aop:after-throwing>` : 핵심 기능 실행 중 Exception이 발생하면 Advice를 실행
        4) `<aop:after>` : 핵심 기능 실행 후에 Advice를 실행(Exception이 발생하더라도 ...)
        5) `<aop:arrond>` : 핵심 기능 실행 전/후 및 Exception 발생시에도 Advice를 실행
2. 어노테이션을 이용하는 방법
    - @AspectJ 어노테이션을 이용하는 방법
3. 스프링에서 AOP 구현 방법은 프록시(Proxy)를 이용한다.
    - Client(호출부) ------> Proxy(대리인/대행) ------> Target(핵심기능)

---

## AOP AspectJ Point-cut 표현식(Expression)]

1. Point-cut을 지정할 때 사용하는 표현식으로 AspectJ 문법을 사용한다.
    - \* : 모든
    - . : 현재
    - .. : 0개 이상
2. within
    - expression="within(com.udemy.springbasic.ex07aop.sample01.\*)" : com.udemy.springbasic.ex07aop.sample01 패키지 안에 있는
      모든 메소드
    - expression="within(com.udemy.springbasic.ex07aop.sample01..\*)" : com.udemy.springbasic.ex07aop.sample01 패키지 및 하위
      패키지 안에 있는 모든 메소드
    - expression="within(com.udemy.springbasic.ex07aop.sample01.Student)" :
      com.udemy.springbasic.ex07aop.sample01.Student 클래스 안에 있는 모든 메소드
3. execution
    - expression="execution(public void get\*(..))" : public void인 이름이 get으로 시작하는 모든 메소드(인자가 0개 또는 그 이상)
    - expression="execution(* com.udemy.springbasic.ex07aop.\*.\*())" : com.udemy.springbasic.ex07aop 패키지의 파라미터가 없는 모든
      메소드(맨 앞에 \*이 붙여지면 접근 제한자(public, default, protected, private)를 상관하지 않겠다는 의미이다.)
    - expression="execution(* com.udemy.springbasic.ex07aop..\*.\*())" : com.udemy.springbasic.ex07aop 패키지 및 하위 패키지 안에
      있는 파라미터가 없는 모든 메소드
    - expression="execution(* com.udemy.springbasic.ex07aop.sample01.Student.*())" :
      com.udemy.springbasic.ex07aop.sample01.Student 클래스 안에 있는 파라미터가 없는 모든 메소드
4. (참고) bean
    - bean(student) : student Bean에만 적용
    - bean(*er) : ~er로 끝나는 Bean에만 적용