package org.java.web;

import org.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName CustomerController
 * @Description 客户的控制层
 * @Author Administrator
 * @Date 2018/9/22 0022 17:16
 * @Version 1.0
 **/
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * @Author Administrator
     * @Description 验证登录
     * @Date 8:35 2018/9/25 0025
     * @Param [map]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/user/checkLogin")
    public Map<String,Object> checkLogin(@RequestBody Map<String,Object> map){
          Map<String,Object> user=customerService.checkLogin(map);
          return user;
    }

    @RequestMapping("/user/registCustomer")
    public void registCustomer(@RequestBody Map<String,Object> map){
            customerService.registCustomer(map);
    }

    @RequestMapping("/user/addContacts")
    public void addContacts(@RequestBody Map<String,Object> map){
        customerService.addContacts(map);
    }

    @RequestMapping("/user/queryContacts")
    public List<Map<String,Object>> queryContacts(@RequestBody Map<String,Object> map){
        List<Map<String,Object>> contacts=customerService.queryContacts(map);
        return contacts;
    }

    @RequestMapping("/user/queryContact")
    public Map<String,Object> queryContact(Integer con_id){
        return customerService.queryContact(con_id);
    }

}
