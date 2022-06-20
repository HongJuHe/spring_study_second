package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.discount.DiscountPolicy;
import hello.core.order.discount.FixDiscountPolicy;
import hello.core.order.discount.RateDiscountPolicy;

public class AppConfig {

    //따로 생성자를 구현해서 여기서 직접 인스턴스를 넣어준다 (생성자 주입)
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }

    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
