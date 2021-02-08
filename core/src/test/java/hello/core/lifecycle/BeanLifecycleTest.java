package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    public void lifecycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);

        NetworkClient bean = ac.getBean(NetworkClient.class);

        // close() 해주기 위해서 AnnotationConfigApplicationContext 혹은 인터페이스인 ConfigurableApplicationContext로 선언한다.
        ac.close();
    }


    @Configuration
    static class LifecycleConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        /*
            destroyMethod 의 추가적인 기능
            외부 라이브러리는 대부분 'close'나 'shutdown' 이다.
            기본 값이 inferred:추론으로 등록되어있다.
            두 가지 이름을 찾아서 종료메서드를 추론하여 종료 호출 해준다.
        * */
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
