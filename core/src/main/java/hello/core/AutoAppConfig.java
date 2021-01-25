package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component 어노테이션이 붙은 클래스를 스캔하여  빈 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 에제 데이터 유지를 위해 Configuration 어노테이션에 해당하는 클래스들은 제외해주었다.
)
public class AutoAppConfig {

}
