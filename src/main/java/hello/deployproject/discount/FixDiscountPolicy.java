package hello.deployproject.discount;

import hello.deployproject.member.Grade;
import hello.deployproject.member.Member;

/**
 * 고정 할인 정책을 구현하는 클래스입니다.
 * VIP 등급의 멤버에게만 할인이 적용됩니다.
 */
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인

    /**
     * 멤버에 대한 가격에 할인을 적용합니다.
     * 멤버가 VIP 등급인 경우에만 할인이 적용됩니다.
     *
     * @param member 할인이 적용될 멤버.
     * @param price 할인 전 원래 가격.
     * @return 적용될 할인 금액. VIP 등급이 아닌 경우 0을 반환합니다.
     */
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
