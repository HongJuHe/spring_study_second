package hello.core.order;

import hello.core.order.discount.DiscountPolicy;
import hello.core.order.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{
    //주문 로직을 만들려면 회원 조회, 할인 정책 서비스가 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /*객체지향 원칙을 준수하기 위해 역할, 구현을 분리하고 다형성을 활용했다.
    * 위 코드를 보면 DIP - 인터페이스 뿐만 아니라 구현 클래스에도 의존
    * OCP - 변경하지 않고 확장이 되지 않는다 -> 구체 클래스를 변경할 때, 클라이언트 코드도 함께 변경 필요
    * 이를 해결하려면 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를 대신 생성하고 주입할 필요가 있다*/
    private DiscountPolicy discountPolicy; //이것만 쓰면 DIP는 지켰지만 구현 객체가 없으니깐 당연히 NPE 발생


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾기
        //orderService 입장에서 discountPolicy를 몰라도 됨 -> 단일 체계 원칙 지킴!
        //할인 정책이 바뀌더라도 orderService에서 수정할 필요 없음
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인된 가격 받기

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
