package hello.deployproject;

import hello.deployproject.discount.DiscountPolicy;
import hello.deployproject.discount.RateDiscountPolicy;
import hello.deployproject.member.MemberRepository;
import hello.deployproject.member.MemberService;
import hello.deployproject.member.MemberServiceImpl;
import hello.deployproject.member.MemoryMemberRepository;
import hello.deployproject.order.OrderService;
import hello.deployproject.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
