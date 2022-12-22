package com.qf.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LengthFilter implements Filter {

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		HttpServletResponse res=(HttpServletResponse)response;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		if(msg.length()>10){
			out.println("输入的文本内容 不能超过10个字");
			return;
		}
		chain.doFilter(request, response);
		
	}

	

}
