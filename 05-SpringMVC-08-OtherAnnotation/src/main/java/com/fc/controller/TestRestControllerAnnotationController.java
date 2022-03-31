package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//此注解用于将当前类注入到Spring容器中
@RestController
@RequestMapping("annotation")
public class TestRestControllerAnnotationController {
    @RequestMapping("getUser")
    public User getUser(){
        return new User("易烊千玺","12345");
    }
    @RequestMapping("toIndex")
    public String toIndex(){
        return "/index.jsp";
    }

}
