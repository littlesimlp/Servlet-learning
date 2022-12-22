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
		//�������ĳ�ʼ������
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
				out.println("�����Ϣ�����в������������������");
				out.close();
				return ;
			}
			//���������ͨ�� ������������뵽�����Servlet����
			//FileterChain ��ʾ�������� ��������doFilter��������������������ú��������������� 
			//���û������������ �͵��ö�ӦServlet���
			arg2.doFilter(request, response);
		
	}
	
	@Override
	public void destroy() {
		//ʲô���Ĵ����д���⣿
		//��Դ�ͷ��ԵĴ���д����
		
	}

}












