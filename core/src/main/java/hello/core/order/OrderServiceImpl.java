package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MemberRepository memberRepository;
    /*
     이렇게 생성하는 경우 new 객체 생성하면 nullPointException이 발생한다.
     테스트 하기 위해서는 다시 setter 메서드를 만들어주어야한다.
     */

    @Autowired
    private DiscountPolicy discountPolicy;

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
