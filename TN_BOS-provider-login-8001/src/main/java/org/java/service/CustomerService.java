package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName CustomerService
 * @Description 客户服务层
 * @Author Administrator
 * @Date 2018/9/22 0022 16:26
 * @Version 1.0
 **/
public interface CustomerService {

    //登录验证
    Map<String,Object> checkLogin(Map<String,Object> map);

    //注册客户
    void registCustomer(Map<String,Object> map);

    //添加联系人
    void addContacts(Map<String,Object> map);

    //获取客户相关的联系人
    List<Map<String,Object>> queryContacts(Map<String,Object> map);

    //获取单个联系人信息
    Map<String,Object> queryContact(Integer con_id);
}
