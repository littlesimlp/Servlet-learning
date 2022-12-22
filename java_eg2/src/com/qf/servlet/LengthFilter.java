package com.qf.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LengthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        request.setCharacterEncoding("utf-8");
        String msg=request.getParameter("msg");
        HttpServletResponse res=(HttpServletResponse)response;
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();
        if(msg.length()>10) {
            out.println("Too long");
            out.close();
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
