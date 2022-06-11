package hello.core.order.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//정액 할인 서비스
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //enum 타입은 == 을 쓰는게 맞다
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
