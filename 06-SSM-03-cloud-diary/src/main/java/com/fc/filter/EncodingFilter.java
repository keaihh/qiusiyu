package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*", initParams = {
        @WebInitParam(name = "contextType", value = "text/html;charset=UTF-8"),
        @WebInitParam(name = "CharacterEncoding", value = "UTF-8")
})
public class EncodingFilter implements Filter {
    private String characterEncoding;
    private String contextType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contextType = filterConfig.getInitParameter("contextType");
        characterEncoding = filterConfig.getInitParameter("CharacterEncoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求和响应对象强转为支持HTTP协议的对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding(characterEncoding);
        response.setContentType(contextType);

        filterChain.doFilter(request, response);
     }

    @Override
    public void destroy() {
    }
}
