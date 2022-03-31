package com.fc.controller;

import com.fc.entity.Clazz;
import com.fc.entity.User;
import com.fc.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

@Controller
//@RequestMapping 请求映射的url路径，也可加/，也可以不加
@RequestMapping("user")
public class UserController {
    @RequestMapping("register")
    public String register(String name, Integer age, String gender, String birthday,String info){
        System.out.println(name+""+age+""+gender+""+birthday+""+info);
        return "/success.jsp";
    }
    @RequestMapping("getBean")
    public String getBean(User user){
        System.out.println(user);
        return "/success.jsp";
    }
    @RequestMapping("getNestedBean")
    public String getNestedBean(UserInfo userInfo){
        System.out.println(userInfo);
        return "/success.jsp";
    }
    @RequestMapping("getListAndMap")
    public String getListAndMap(Clazz clazz){
        System.out.println(clazz);
        return "/success.jsp";
    }
    @RequestMapping("getRequestParameter")
    public String getRequestParameter(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+" "+password);
        return "/success.jsp";
    }

}
