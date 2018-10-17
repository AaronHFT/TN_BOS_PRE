package org.java.web;

import org.java.service.LoginClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ProjectName TN_BOS
 * @ClassName UserController
 * @Description 客户控制类
 * @Author Administrator
 * @Date 2018/9/25 0025 11:16
 * @Version 1.0
 **/
@Controller
public class UserController {

    @Autowired
    private LoginClientService loginClientService;

    /**
     * @Author Administrator
     * @Description 初始化注册页面
     * @Date 10:26 2018/9/27 0027
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initRegist")
    public String initRegist(){
        return "/regist";
    }

    /**
     * @Author Administrator
     * @Description 初始化关于页面
     * @Date 13:30 2018/10/7 0007
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initAbout")
    public String initAbout(){return "/about";}

    /**
     * @Author Administrator
     * @Description 初始化服务页面
     * @Date 13:31 2018/10/7 0007
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initService")
    public String initService(){return "/service";}

    /**
     * @Author Administrator
     * @Description 初始化工作页面
     * @Date 13:32 2018/10/7 0007
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initWork")
    public String initWork(){return "/work";}

    /**
     * @Author Administrator
     * @Description 初始化首页
     * @Date 10:27 2018/9/27 0027
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initIndex")
    public String index(){
        return "/index";
    }

    /**
     * @Author Administrator
     * @Description 注册新客户
     * @Date 20:11 2018/9/27 0027
     * @Param [map]
     * @return java.lang.String
     **/
    @RequestMapping("/regist")
    public String regist(@RequestParam Map<String,Object> map){
        loginClientService.registCustomer(map);
        return "redirect:/initIndex";
    }

    /**
     * @Author Administrator
     * @Description 登录验证
     * @Date 20:15 2018/9/27 0027
     * @Param [map, ses]
     * @return java.lang.String
     **/
    @RequestMapping("/login")
    public String login(@RequestParam Map<String,Object> map, HttpSession ses){
        map=loginClientService.checkLogin(map);
        ses.setAttribute("customer", map);
        return "redirect:/initIndex";
    }

    /**
     * @Author Administrator
     * @Description 退出登录
     * @Date 20:16 2018/9/27 0027
     * @Param [ses]
     * @return java.lang.String
     **/
    @RequestMapping("/logout")
    public String logout(HttpSession ses){
        ses.removeAttribute("customer");
        return "redirect:/initIndex";
    }

    /**
     * @Author Administrator
     * @Description 初始化添加联系人界面
     * @Date 20:59 2018/9/27 0027
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/initContacts")
    public String initContacts(){
        return "/addContacts";
    }

    @RequestMapping("/addContacts")
    public String addContacts(@RequestParam Map<String,Object> map,HttpSession ses){
        Map<String,Object> customer= (Map<String, Object>) ses.getAttribute("customer");
        map.put("cus_id", customer.get("cus_id"));
        loginClientService.addContacts(map);
        return "redirect:/initIndex";
    }

}
