package org.java.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderClientServiceFallbackFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/25 0025 9:10
 * @Version 1.0
 **/
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {

    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {
            @Override
            public Map<String, Object> queryOrder(Map<String, Object> map) {
                map.put("order_id", "该订单"+map.get("order_id")+"没有对应的信息，客户端提供的降级信息，此刻按订单号查询订单服务已经关闭");
                return map;
            }

            @Override
            public void addOrder(Map<String, Object> map) {

            }

            @Override
            public void addGoodReach(Map<String, Object> map) {

            }

            @Override
            public void addCountmenty(Map<String, Object> map) {

            }

            @Override
            public List<Map<String, Object>> queryOrders(Map<String, Object> map) {
                List<Map<String,Object>> orders=new ArrayList<>();
                orders.add(map);
                map.put("err","该账户"+map.get("cus_short")+"没有对应的信息，客户端提供的降级信息，此刻查询所有订单服务已经关闭");
                return orders;
            }

            @Override
            public List<Map<String, Object>> queryOrderTypes() {
                List<Map<String,Object>> orderTypes=new ArrayList<>();
                Map<String,Object> map=new HashMap<>();
                orderTypes.add(map);
                map.put("err","没有对应的信息，客户端提供的降级信息，此刻查询所有订单类型服务已经关闭");
                return orderTypes;
            }

            @Override
            public Map<String, Object> queryOrderType(Integer orderType_id) {
                Map<String,Object> map=new HashMap<>();
                map.put("err", "没有对应的信息，客户端提供的降级信息，此刻选择订单类型服务已经关闭");
                return map;
            }

            @Override
            public List<Map<String, Object>> queryWebNodes() {
                List<Map<String,Object>> webNodes=new ArrayList<>();
                Map<String,Object> map=new HashMap<>();
                webNodes.add(map);
                map.put("err","没有对应的信息，客户端提供的降级信息，此刻查询所有网点服务已经关闭");
                return webNodes;
            }
        };
    }
}
