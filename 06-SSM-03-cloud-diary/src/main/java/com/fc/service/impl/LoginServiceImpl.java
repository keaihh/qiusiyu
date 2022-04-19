package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.LoginService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TbUserMapper tbUserMapper;
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<TbUser> tbUsers = this.tbUserMapper.selectByExample(tbUserExample);
        if (tbUsers.isEmpty()) {
            Map<String, Object> map = new HashMap();
            map.put("username", username);
            map.put("password", password);
            ResultInfo resultInfo = new ResultInfo(200, "登录失败，用户名或密码错误", false, map);
            modelAndView.addObject(resultInfo);
            modelAndView.setViewName("/login.jsp");
        } else {
            System.out.println(tbUsers.get(0));
            HttpSession session = request.getSession(true);
            TbUser user = (TbUser)tbUsers.get(0);
            session.setAttribute("user", user);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            if (remember != null) {
                cookie.setMaxAge(1800000);
            } else {
                cookie.setMaxAge(0);
            }

            response.addCookie(cookie);
            modelAndView.setViewName("forward:/index/page");
        }

        return modelAndView;
    }

    @Override
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        modelAndView.setViewName("redirect:/login.jsp");
        return modelAndView;
    }
}
