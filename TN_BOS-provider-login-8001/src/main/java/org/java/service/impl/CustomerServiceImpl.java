package org.java.service.impl;

import org.java.dao.CustomerMapper;
import org.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName CustomerServiceImpl
 * @Description 客户的服务层
 * @Author Administrator
 * @Date 2018/9/22 0022 16:27
 * @Version 1.0
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Map<String, Object> checkLogin(Map<String, Object> map) {
        return customerMapper.checkLogin(map);
    }

    @Override
    public void registCustomer(Map<String, Object> map) {
              customerMapper.registCustomer(map);
    }

    @Override
    public void addContacts(Map<String, Object> map) {
              customerMapper.addContacts(map);
    }

    @Override
    public List<Map<String, Object>> queryContacts(Map<String, Object> map) {
        return customerMapper.queryContacts(map);
    }

    @Override
    public Map<String, Object> queryContact(Integer con_id) {
        return customerMapper.queryContact(con_id);
    }
}
