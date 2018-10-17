package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ProjectName TN_BOS
 * @ClassName Consumer80_App
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 9:52
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"org.java"})
public class Consumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80_App.class,args);
    }
}
