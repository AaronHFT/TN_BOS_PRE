package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderProvider8002_App
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/18 0018 20:50
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class OrderProvider8002_App {
    public static void main(String[] args) {
        SpringApplication.run(OrderProvider8002_App.class, args);
    }
}
