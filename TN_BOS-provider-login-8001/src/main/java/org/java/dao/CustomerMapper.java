package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName CustomerMapper
 * @Description 客户的dao类
 * @Author Administrator
 * @Date 2018/9/22 0022 16:04
 * @Version 1.0
 **/
@Mapper
public interface CustomerMapper {

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
