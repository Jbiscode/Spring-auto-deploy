package hello.deployproject.order;

import hello.deployproject.discount.DiscountPolicy;
import hello.deployproject.discount.FixDiscountPolicy;
import hello.deployproject.discount.RateDiscountPolicy;
import hello.deployproject.member.Member;
import hello.deployproject.member.MemberRepository;
import hello.deployproject.member.MemoryMemberRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
