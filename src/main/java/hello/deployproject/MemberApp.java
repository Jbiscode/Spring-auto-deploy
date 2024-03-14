package hello.deployproject;

import hello.deployproject.member.Grade;
import hello.deployproject.member.Member;
import hello.deployproject.member.MemberService;
import hello.deployproject.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        System.out.println("member = " + member.getName());
        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
    }
}
