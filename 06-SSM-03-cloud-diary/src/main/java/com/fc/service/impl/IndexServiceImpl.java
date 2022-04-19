package com.fc.service.impl;

import com.fc.entity.TbUser;
import com.fc.service.IndexService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public ModelAndView page(ModelAndView modelAndView, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        TbUser user = (TbUser)session.getAttribute("user");
        modelAndView.setViewName("forward:/index.jsp");
        return modelAndView;
    }
}
