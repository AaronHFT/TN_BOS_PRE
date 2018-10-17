package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ProjectName TN_BOS
 * @ClassName Consumer_DashBoard_App
 * @Description TODO
 * @Author Administrator
 * @Date 2018/10/6 0006 20:55
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_DashBoard_App.class,args);
    }
}
