package hello.deployproject.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        StatefulService statefulService1 = new StatefulService();
        StatefulService statefulService2 = new StatefulService();

        // ThreadA: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // ThreadA: 사용자 A 주문 금액 조회
        // 사용자 A가 10000원을 주문했지만, 사용자 B가 20000원을 주문했기 때문에 20000원이 출력된다.
        // 이는 statefulService1과 statefulService2가 같은 인스턴스를 참조하기 때문이다.
        assertEquals(10000, price);
    }



}