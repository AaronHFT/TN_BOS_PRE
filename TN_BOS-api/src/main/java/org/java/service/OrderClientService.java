package org.java.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderClientService
 * @Description 利用Feign处理登录微服务，简化客户端的调用操作
 * @Author Administrator
 * @Date 2018/9/25 0025 9:05
 * @Version 1.0
 **/
@FeignClient(value="TN-BOS-ORDER",fallbackFactory = OrderClientServiceFallbackFactory.class)
public interface OrderClientService {
    @RequestMapping("/order/queryOrder")
     Map<String,Object> queryOrder(@RequestBody Map<String, Object> map);


    @RequestMapping("/order/addOrder")
    void addOrder(@RequestBody Map<String, Object> map);

    @RequestMapping("/order/addGoodReach")
     void addGoodReach(@RequestBody Map<String, Object> map);


    @RequestMapping("/order/addCountmenty")
    void addCountmenty(@RequestBody Map<String, Object> map);

    @RequestMapping("/order/queryOrders")
    List<Map<String,Object>> queryOrders(@RequestBody Map<String, Object> map);

    //获取订单类型
    @RequestMapping("/order/queryOrderTypes")
    List<Map<String,Object>> queryOrderTypes();

    //获取单个订单类型
    @RequestMapping("/order/queryOrderType")
    Map<String,Object> queryOrderType(@RequestParam("orderType_id") Integer orderType_id);

    //获取所有网点
    @RequestMapping("/order/queryWebNodes")
    List<Map<String,Object>> queryWebNodes();
}
