package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("2. memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("2. discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    @Autowired // 생성자가 딱 1개만 있으면 @Autowired 를 생략해도 된다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy  = discountPolicy;
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
