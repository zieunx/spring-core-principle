package hello.core.order;

import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        // 생성자 주입은 컴파일부터 필요한 의존성 주입에 대해 개발자가 확인할 수 있다.
        orderService.createOrder(1L, "itemA", 10000);
    }
}
