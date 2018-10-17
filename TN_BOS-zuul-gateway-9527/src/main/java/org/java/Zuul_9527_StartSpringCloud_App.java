package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ProjectName TN_BOS
 * @ClassName Zuul_9527_StartSpringCloud_App
 * @Description 网关启动类
 * @Author Administrator
 * @Date 2018/10/7 0007 14:18
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloud_App {
    public static void main(String[] args)
    {
        SpringApplication.run(Zuul_9527_StartSpringCloud_App.class, args);
    }
}
