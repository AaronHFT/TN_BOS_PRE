package org.java.web;

import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName CustomerController
 * @Description 订单的控制层
 * @Author Administrator
 * @Date 2018/9/22 0022 17:16
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * @Author Administrator
     * @Description 验证登录
     * @Date 8:35 2018/9/25 0025
     * @Param [map]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/order/queryOrders")
    public List<Map<String,Object>> queryOrders(@RequestBody Map<String,Object> map){
          List<Map<String,Object>> orders=orderService.queryOrders(map);
          return orders;
    }

    /**
     * @Author Administrator
     * @Description 添加订单
     * @Date 14:38 2018/10/6 0006
     * @Param [map]
     * @return void
     **/
    @RequestMapping("/order/addOrder")
    public void addOrder(@RequestBody Map<String,Object> map){
        orderService.addOrder(map);
    }

    /**
     * @Author Administrator
     * @Description 添加收发货通知单
     * @Date 14:38 2018/10/6 0006
     * @Param [map]
     * @return void
     **/
    @RequestMapping("/order/addGoodReach")
    public void addGoodReach(@RequestBody Map<String,Object> map){
        orderService.addGoodReach(map);
    }

    /**
     * @Author Administrator
     * @Description 添加结算单
     * @Date 14:38 2018/10/6 0006
     * @Param [map]
     * @return void
     **/
    @RequestMapping("/order/addCountmenty")
    public void addCountmenty(@RequestBody Map<String,Object> map){
        orderService.addCountmenty(map);
    }

    /**
     * @Author Administrator
     * @Description 查询订单
     * @Date 14:39 2018/10/6 0006
     * @Param [map]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @RequestMapping("/order/queryOrder")
    public Map<String,Object> queryOrder(@RequestBody Map<String,Object> map){
        Map<String,Object> order=orderService.queryOrder(map);
        return order;
    }

    /**
     * @Author Administrator
     * @Description 查询所有订单类型
     * @Date 14:39 2018/10/6 0006
     * @Param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @RequestMapping("/order/queryOrderTypes")
    public List<Map<String,Object>> queryOrderTypes(){
        return orderService.queryOrderTypes();
    }

    /**
     * @Author Administrator
     * @Description 查询单个订单信息
     * @Date 14:45 2018/10/6 0006
     * @Param [orderType_id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/order/queryOrderType")
    public Map<String,Object> queryOrderType(Integer orderType_id){
        return orderService.queryOrderType(orderType_id);
    }

    /**
     * @Author Administrator
     * @Description 查询网点
     * @Date 14:39 2018/10/6 0006
     * @Param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @RequestMapping("/order/queryWebNodes")
    public List<Map<String,Object>> queryWebNodes(){
        return orderService.queryWebNodes();
    }

}
