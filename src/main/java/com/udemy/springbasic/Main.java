package com.udemy.springbasic;

import com.udemy.springbasic.ex01di.sample01.Dao;
import com.udemy.springbasic.ex01di.sample01.DaoImpl;
import com.udemy.springbasic.ex01di.sample02.MyGetSum;
import com.udemy.springbasic.ex01di.sample03.ExDao;
import com.udemy.springbasic.ex01di.sample04.Person;
import com.udemy.springbasic.ex01di.sample04.PersonInfo;
import com.udemy.springbasic.ex01di.sample05.MyBatisService;
import com.udemy.springbasic.ex01di.sample06.Car;
import com.udemy.springbasic.ex01di.sample07.BaseBallTeam;
import com.udemy.springbasic.ex01di.sample07.Player;
import com.udemy.springbasic.ex01di.sample07.PlayerInfo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        // XML 설정 파일을 읽어 올 때에는 GenericXmlApplicationContext를 사용한다.
        // 설정 파일을 여러 개 등록하여 사용 가능하다.
        AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application-context.xml", "classpath:baseballteam-context.xml");
        Dao dao = ctx.getBean("daoImpl", DaoImpl.class);
        dao.print(); //Dao dao = new Dao(); 코드를 작성하지 않았음에도 불구하고 dao 객체의 print() 메소드를 호출할 수 있다.
        System.out.println();

        MyGetSum myGetSum = ctx.getBean("myGetSum", MyGetSum.class);
        myGetSum.sum();
        System.out.println();

        ExDao exDao = ctx.getBean("exDao", ExDao.class);
        exDao.print();
        System.out.println();

        PersonInfo personInfo = ctx.getBean("personInfo", PersonInfo.class);
        personInfo.getPersonInfo();
        System.out.println();

        Person person = ctx.getBean("person02", Person.class);
        personInfo.setPerson(person);
        personInfo.getPersonInfo();
        System.out.println();

        MyBatisService myBatisService = ctx.getBean("myBatisService", MyBatisService.class);
        myBatisService.myBatisTest();
        System.out.println();

        Car car = ctx.getBean("car", Car.class);
        car.drive();
        System.out.println();

        Player player01 = ctx.getBean("player01", Player.class);
        System.out.println(player01.getName());
        System.out.println(player01.getPosition());
        System.out.println();

        PlayerInfo playerInfo = ctx.getBean("playerInfo", PlayerInfo.class);
        Player playerTmp = playerInfo.getPlayer();
        System.out.println(playerTmp.getName());
        System.out.println(playerTmp.getPosition());
        System.out.println();

        if (player01 == playerTmp) {
            System.out.println("player01 == playerTmp");
        }

        System.out.println();

        Player player02 = ctx.getBean("player02", Player.class);
        System.out.println(player02.getName());
        System.out.println(player02.getPosition());
        System.out.println();

        BaseBallTeam baseBallTeam = ctx.getBean("baseBallTeam", BaseBallTeam.class);
        System.out.println("======== 야구 팀 구성 ========");
        System.out.println("감독" + baseBallTeam.getManger());
        System.out.println("타격코치" + baseBallTeam.getBattingCoach());
        System.out.println("투수코치" + baseBallTeam.getPitchingCoach());
        System.out.println("타자" + baseBallTeam.getHitter());
        System.out.println("투수" + baseBallTeam.getPitcher());
        System.out.println();

        ctx.close();
    }
}
