package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IndexService {
    ModelAndView page(ModelAndView modelAndView, HttpServletRequest request);
}
