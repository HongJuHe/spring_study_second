package hello.core;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.order.discount.FixDiscountPolicy;

public class AppConfig {

    //따로 생성자를 구현해서 여기서 직접 인스턴스를 넣어준다 (생성자 주입)
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new FixDiscountPolicy(), new MemoryMemberRepository());
    }

}
