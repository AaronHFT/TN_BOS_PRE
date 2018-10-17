package org.java.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName LoginClientServiceFallbackFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 9:10
 * @Version 1.0
 **/
@Component
public class LoginClientServiceFallbackFactory implements FallbackFactory<LoginClientService> {
    @Override
    public LoginClientService create(Throwable throwable) {
        return new LoginClientService() {
            @Override
            public Map<String, Object> checkLogin(Map<String, Object> map) {
                map.put("cus_name", "该账户"+map.get("cus_short")+"没有对应的信息，客户端提供的降级信息，此刻登录服务已经关闭");
                return map;
            }

            @Override
            public void registCustomer(Map<String, Object> map) {

            }

            @Override
            public void addContacts(Map<String, Object> map) {

            }

            @Override
            public List<Map<String, Object>> queryContacts(Map<String, Object> map) {
                List<Map<String,Object>> contacts=new ArrayList<>();
                contacts.add(map);
                map.put("cus_name","该账户"+map.get("cus_short")+"没有对应的信息，客户端提供的降级信息，此刻查询联系人服务已经关闭");
                return contacts;
            }

            @Override
            public Map<String, Object> queryContact(Integer con_id) {
                Map<String,Object> map=new HashMap<>();
                map.put("err", "没有对应的信息，客户端提供的降级信息，此刻选择联系人服务已经关闭");
                return map;
            }
        };
    }
}
