package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        // final로 생성자주입이 되지 않은 빈에 대해 컴파일 시 알 수 있다.
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        /*
        단일 책임 원칙을 잘 지켰기 때문에, Order 쪽에서는 discount 에 관련하여 전혀 관여하지 않는다.
        */

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


    // test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
