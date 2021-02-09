package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;


// 로그를 출력하기 위한 클래스
@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + " [" + message + "]");
    }

    @PostConstruct
    public void init() {
        this.uuid = UUID.randomUUID().toString(); // 절대로 겹치지 않는다고 봐도된다. (로또의 로또의 로또의... 확률보다 더 낮다는)..
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
