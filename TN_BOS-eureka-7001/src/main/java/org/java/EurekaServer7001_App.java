package org.java;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName TN_BOS
 * @ClassName EurekaServer7001_App
 * @Description EurekaServer服务器端启动类,接受其它微服务注册进来
 * @Author Administrator
 * @Date 2018/9/18 0018 20:34
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
}
