package org.java.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderMapper
 * @Description 订单的dao类
 * @Author Administrator
 * @Date 2018/9/22 0022 16:04
 * @Version 1.0
 **/
@Mapper
public interface OrderMapper {

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

    //获取所有订单类型
    List<Map<String,Object>> queryOrderTypes();

    //查询单个订单类型
    Map<String,Object> queryOrderType(Integer orderType_id);

    //获取所有网点
    List<Map<String,Object>> queryWebNodes();
}
