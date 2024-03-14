package hello.deployproject.discount;

import hello.deployproject.member.Member;

/**
 * 이 인터페이스는 할인 정책을 나타냅니다.
 * 이 인터페이스의 구현체는 자체 할인 규칙을 정의할 수 있습니다.
 */
public interface DiscountPolicy {

    /**
     * 멤버에 대한 가격에 할인을 적용합니다.
     *
     * @param member 할인이 적용될 멤버.
     * @param price 할인 전 원래 가격.
     * @return 적용될 할인 금액.
     */
    int discount(Member member, int price);
}