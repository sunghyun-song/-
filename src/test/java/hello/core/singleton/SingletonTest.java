package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();


        //참조값이 다른 것을 확인
        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        //memverService1 != memverService2
        Assertions.assertNotEquals(memberService1, memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("SingletonService1= " + singletonService1);
        System.out.println("SingletonService2= " + singletonService2);

        Assertions.assertEquals(singletonService1, singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 스프링")
    void singletonContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        //참조값이 다른 것을 확인
        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        //memverService1 != memverService2
        Assertions.assertEquals(memberService1, memberService2);
    }
}
