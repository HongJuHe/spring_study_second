package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //주문 로직을 만들려면 회원 조회, 할인 정책 서비스가 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾기
        //orderService 입장에서 discountPolicy를 몰라도 됨 -> 단일 체계 원칙 지킴!
        //할인 정책이 바뀌더라도 orderService에서 수정할 필요 없음
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인된 가격 받기

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
