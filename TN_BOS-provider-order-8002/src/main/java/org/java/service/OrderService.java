package org.java.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderService
 * @Description 客户服务层
 * @Author Administrator
 * @Date 2018/9/22 0022 16:26
 * @Version 1.0
 **/
public interface OrderService {

    //获取客户所有订单
    List<Map<String,Object>> queryOrders(Map<String,Object> map);

    //添加订单
    void addOrder(Map<String,Object> map);

    //添加收发货通知单
    void addGoodReach(Map<String,Object> map);

    //添加结算单
    void addCountmenty(Map<String,Object> map);

    //获取订单号对应的订单
    Map<String,Object> queryOrder(Map<String,Object> map);

    //获取订单类型
    List<Map<String,Object>> queryOrderTypes();

    //获取单个订单类型
    Map<String,Object> queryOrderType(Integer orderType_id);

    //获取所有网点
    List<Map<String,Object>> queryWebNodes();
}
