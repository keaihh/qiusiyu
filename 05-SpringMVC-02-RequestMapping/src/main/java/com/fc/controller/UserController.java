package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping 请求映射的url路径，也可加/，也可以不加
@RequestMapping("user")
public class UserController {
    @RequestMapping(method = RequestMethod.DELETE,value = {"getParam","getParam1","getParam2"})
//    SpringMVC 不需要在request.getParameter方法中获取参数
  public void getParam(String username,String password){
        System.out.println("用户名:"+username+"密码"+password);
  }

}
