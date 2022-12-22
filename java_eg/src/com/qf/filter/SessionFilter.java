package com.qf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String uri=req.getRequestURI();
		//将获取的请求资源路径uri进行字符串切割处理
		String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(path);
		if(path.equals("/login")||path.equals("/style")||path.equals("/checkCode")){
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session=req.getSession();
		//进行session验证
		Object obj=session.getAttribute("e");
		if(obj==null){
			//跳转回登录页面 
			res.sendRedirect("login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	
}
