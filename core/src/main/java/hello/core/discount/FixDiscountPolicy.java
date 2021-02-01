package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
/*
기존에 RateDiscountPolicy 에 @Component 추가 되어있었다.

FixDiscountPolicy 에도 @Component 추가 : 에러 발생 ->
No qualifying bean of type 'hello.core.discount.DiscountPolicy' available: expected single matching bean but found 2: fixDiscountPolicy,rateDiscountPolicy
* */
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum은 equals함수가 아닌 == 으로 비교한다.
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
