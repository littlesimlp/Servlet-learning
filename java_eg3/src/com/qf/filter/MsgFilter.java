package com.qf.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MsgFilter implements Filter{
	String str="";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//过滤器的初始化方法
		str=filterConfig.getInitParameter("str");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
			HttpServletRequest req=(HttpServletRequest)request;
			request.setCharacterEncoding("utf-8");
			String msg=request.getParameter("msg");
			HttpServletResponse res=(HttpServletResponse)response;
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			if(msg.indexOf(str)>0){
				out.println("你的信息当中有不文明词语，请重新输入");
				out.close();
				return ;
			}
			//让这个请求通过 过滤器进入进入到后面的Servlet当中
			//FileterChain 表示过滤器链 调用它的doFilter方法可以让请求继续调用后续的其他过滤器 
			//如果没有其他过滤器 就调用对应Servlet组件
			arg2.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		//什么样的代码会写在这？
		//资源释放性的代码写在这
		
	}

}












