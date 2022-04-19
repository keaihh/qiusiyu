package com.fc.controller;

import com.fc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("index")
public class IndexController extends HttpServlet {
    @Autowired
    private IndexService indexService;

    public IndexController() {
    }

    @RequestMapping("page")
    public ModelAndView page(ModelAndView modelAndView, HttpServletRequest request){
        return indexService.page(modelAndView,request);
    }

}
