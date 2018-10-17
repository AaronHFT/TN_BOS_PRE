package org.java.web;

import org.java.service.LoginClientService;
import org.java.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ProjectName TN_BOS
 * @ClassName OrderController
 * @Description 订单控制类
 * @Author Administrator
 * @Date 2018/9/29 0029 11:04
 * @Version 1.0
 **/
@Controller
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    @Autowired
    private LoginClientService loginClientService;

    /**
     * @Author Administrator
     * @Description 初始化订单页面
     * @Date 14:58 2018/10/6 0006
     * @Param [model, ses]
     * @return java.lang.String
     **/
    @RequestMapping("/initOrder")
    public String initOrder(Model model, HttpSession ses){
        Map<String,Object> customer= (Map<String, Object>) ses.getAttribute("customer");
        model.addAttribute("orderTypes", orderClientService.queryOrderTypes());
        model.addAttribute("contacts", loginClientService.queryContacts(customer));
        //model.addAttribute("webNodes", orderClientService.queryWebNodes());
        return "/order";
    }

    /**
     * @Author Administrator
     * @Description 获取单个订单类型
     * @Date 16:14 2018/10/6 0006
     * @Param [orderType_id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/getOrderType")
    @ResponseBody
    public Map<String,Object> getOrderType(Integer orderType_id){
        Map<String,Object> map=orderClientService.queryOrderType(orderType_id);
        return map;
    }

    /**
     * @Author Administrator
     * @Description 获取单个联系人
     * @Date 16:14 2018/10/6 0006
     * @Param [con_id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/getContact")
    @ResponseBody
    public Map<String,Object> getContact(Integer con_id){
        Map<String,Object> con=loginClientService.queryContact(con_id);
        return con;
    }

    @RequestMapping("/searchWebNode")
    @ResponseBody
    public Map<String,Object> searchWebNode(Double webNodes_x,Double webNodes_y){
        //获取所有网点
        List<Map<String,Object>> webNodes=orderClientService.queryWebNodes();
        //当前网点
        Map<String,Object> web=webNodes.get(0);
        //当前两边之和
        Double length=Math.abs(Double.parseDouble(web.get("webNodes_x").toString())-webNodes_x)+Math.abs(Double.parseDouble(web.get("webNodes_y").toString())-webNodes_y);
        for(Map<String,Object> w:webNodes) {
            Double nowLength=Math.abs(Double.parseDouble(w.get("webNodes_x").toString())-webNodes_x)+Math.abs(Double.parseDouble(w.get("webNodes_y").toString())-webNodes_y);
              if (nowLength<length){
                  length=nowLength;
                  web=w;
              }
        }
        return web;
    }

    @RequestMapping("/makeOrder")
    @ResponseBody
    public String makeOrder(@RequestParam Map<String,Object> obj,HttpSession ses){
        System.out.println("开始下单");
        Map<String,Object> con=loginClientService.queryContact(Integer.parseInt(obj.get("con_id").toString()));
        Map<String,Object> customer= (Map<String, Object>) ses.getAttribute("customer");
        //订单编号
        //生成20位主键
        //当前系统时间戳精确到毫秒
        Long simple=System.currentTimeMillis();
        //7位随机数
        //为变量赋随机值1000000-9999999;
        int random=new Random().nextInt(9000000)+1000000;
        String orderId=simple.toString()+random;
        obj.put("cus_id", customer.get("cus_id"));
        obj.put("order_id", orderId);
        obj.put("order_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        obj.put("order_state", "合同签订中");
        //判断是收货还是发货
        int tip=0;
        if ("3".equals(obj.get("orderType_id"))){
             tip=1;
        }
        String goodReach_code=tip+new SimpleDateFormat("yyyyMMdd").format(new Date()).toString()+con.get("con_phone");
        obj.put("goodReach_code", goodReach_code);
        obj.put("goodReach_state", tip+"");
        obj.put("goodReach_standard", "100");
        orderClientService.addOrder(obj);
        orderClientService.addGoodReach(obj);
        orderClientService.addCountmenty(obj);
        return orderId;
    }


    @RequestMapping("/initProcess")
    public String initProcess(Model model,String order_id)throws Exception{
        Map<String,Object> order=new HashMap<>();
        order.put("order_id", order_id);
        order=orderClientService.queryOrder(order);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(order.get("order_time").toString());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,10);
        String arriveDate =format.format(calendar.getTime());
        order.put("arriveDate", arriveDate);
        model.addAttribute("order", order);
        return "/orderchase";
    }

}
