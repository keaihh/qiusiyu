//package com.fc.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//// 自动登录过滤器
//@WebFilter("/*")
//public class AutoLoginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        // 强转
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        // 获取session
//        HttpSession session = request.getSession(false);
//
//        String uri = request.getRequestURI();
//
//        // 如果访问的路径是登录，直接访问
//        if (uri.endsWith("/") || uri.endsWith("index.jsp") || uri.endsWith("getCode") || uri.endsWith("verify") || uri.endsWith("register") || uri.endsWith("verifyUsername") || uri.endsWith(".js") || uri.endsWith("register.html") || uri.endsWith("fail.jsp") || uri.endsWith("login.html") || uri.endsWith("login")) {
//            filterChain.doFilter(request, response);
//        // 如果没有登录，就去登录
//        } else if (session == null || session.getAttribute("user") == null) {
//            response.sendRedirect("login.html");
//        } else {
//            // 如果已经登录过了，直接放行
//            filterChain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
