package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 어노테이션이 붙은 클래스를 스캔하여  빈 등록해준다.
//        basePackages = "hello.core.member", // 탐색할 패키지를 설정할 수 있다.
//        basePackageClasses = AutoAppConfig.class, // 설정 클래스의 패키지의 경로에서 탐색한다.
        // Q. 기본값은 무엇인가? -> @ComponentScan이 붙은 클래스의 경로부터 시작된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 에제 데이터 유지를 위해 Configuration 어노테이션에 해당하는 클래스들은 제외해주었다.
)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
