package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    /* 추상화에도 의존, 구현체에도 의존 -> DIP 위반 */
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given : 대상
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : 동작
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
