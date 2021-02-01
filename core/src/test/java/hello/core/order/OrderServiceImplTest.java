package hello.core.order;

import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        // setter를 통해 의존성을 추가해주어야 한다.
        orderService.createOrder(1L, "itemA", 10000);
    }
}
