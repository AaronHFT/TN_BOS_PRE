package org.java.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName TN_BOS
 * @ClassName ConfigBean
 * @Description 自己配置的配置类
 * @Author Administrator
 * @Date 2018/9/25 0025 10:31
 * @Version 1.0
 **/
@Configuration
public class ConfigBean {

    /**
     * @Author Administrator
     * @Description Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
     * @Date 11:07 2018/9/25 0025
     * @Param []
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
