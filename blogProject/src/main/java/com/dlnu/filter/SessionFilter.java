package com.dlnu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        if (path.equals("/login") || path.equals("/code") || path.equals("/register")){
            filterChain.doFilter(request, response);
            return;
        }

        Object object = session.getAttribute("u");
        if (object ==null){
            //跳转回登录页
            response.sendRedirect("login.jsp");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
