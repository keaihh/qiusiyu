package com.fc.controller;

import com.fc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    public LoginController() {
    }

    @PostMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){

        return loginService.login(request,response);

    }
    @PostMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){

        return loginService.logout(request,response);

    }

}
