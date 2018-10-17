package org.java.service.impl;

import org.java.dao.OrderMapper;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderServiceImpl
 * @Description 订单的服务层
 * @Author Administrator
 * @Date 2018/9/22 0022 16:27
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Map<String, Object>> queryOrders(Map<String, Object> map) {
        return orderMapper.queryOrders(map);
    }

    @Override
    public void addOrder(Map<String, Object> map) {
             orderMapper.addOrder(map);
    }

    @Override
    public void addGoodReach(Map<String, Object> map) {
             orderMapper.addGoodReach(map);
    }

    @Override
    public void addCountmenty(Map<String, Object> map) {
        orderMapper.addCountmenty(map);
    }

    @Override
    public Map<String, Object> queryOrder(Map<String, Object> map) {
        return orderMapper.queryOrder(map);
    }

    @Override
    public List<Map<String, Object>> queryOrderTypes() {
        return orderMapper.queryOrderTypes();
    }

    @Override
    public Map<String, Object> queryOrderType(Integer orderType_id) {
        return orderMapper.queryOrderType(orderType_id);
    }

    @Override
    public List<Map<String, Object>> queryWebNodes() {
        return orderMapper.queryWebNodes();
    }
}
