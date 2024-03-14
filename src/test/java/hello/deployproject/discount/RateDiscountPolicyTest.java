package hello.deployproject.discount;

import hello.deployproject.member.Grade;
import hello.deployproject.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        long memberId = 1L;
        Member member = new Member(memberId, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 12000);
        // then
        assertThat(discount).isEqualTo(1200);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        long memberId = 2L;
        Member member = new Member(memberId, "memberBasic", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member, 12000);
        // then
        assertThat(discount).isEqualTo(0);
    }
}