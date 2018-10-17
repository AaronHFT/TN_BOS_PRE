package org.java.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName LoginClientService
 * @Description 利用Feign处理登录微服务，简化客户端的调用操作
 * @Author Administrator
 * @Date 2018/9/25 0025 9:05
 * @Version 1.0
 **/
@FeignClient(value="TN-BOS-LOGIN",fallbackFactory = LoginClientServiceFallbackFactory.class)
public interface LoginClientService {
    @RequestMapping("/user/checkLogin")
     Map<String,Object> checkLogin(@RequestBody Map<String,Object> map);


    @RequestMapping("/user/registCustomer")
    void registCustomer(@RequestBody Map<String,Object> map);

    @RequestMapping("/user/addContacts")
     void addContacts(@RequestBody Map<String,Object> map);

    @RequestMapping("/user/queryContacts")
    List<Map<String,Object>> queryContacts(@RequestBody Map<String,Object> map);

    @RequestMapping("/user/queryContact")
    Map<String,Object> queryContact(@RequestParam("con_id") Integer con_id);
}
