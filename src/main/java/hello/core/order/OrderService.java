package hello.core.order;

public interface OrderService {
    //클라이언트가 주문 생성을 할 때
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
