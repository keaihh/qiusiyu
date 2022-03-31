package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping 请求映射的url路径，也可加/，也可以不加
@RequestMapping("user")
public class UserController {
    //方法中的@RequestMapping相当于二级路径
    @RequestMapping("login")
    public String login(){
        System.out.println("登陆成功");

        return "/login.jsp";
    }
    @RequestMapping("register")
    public String register(){
        System.out.println("注册成功");

        return "/login.jsp";
    } @RequestMapping("insert")
    public String insert(){
        System.out.println("插入成功");

        return "/login.jsp";
    }
    @RequestMapping("delete")
    public String delete(){
        System.out.println("删除成功");

        return "/login.jsp";
    }


}
