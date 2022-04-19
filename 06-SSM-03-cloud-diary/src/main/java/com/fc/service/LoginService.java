package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    ModelAndView login(HttpServletRequest request, HttpServletResponse response);

    ModelAndView logout(HttpServletRequest request, HttpServletResponse response);
}
