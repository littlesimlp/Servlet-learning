package com.qf.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//获取session
		HttpSession session=request.getSession();
		
		Integer count=(Integer)session.getAttribute("count");
		if(count==null){
			count=1;
		}else{
			count++;
		}
		//将访问次数绑定到session对象
		session.setAttribute("count", count);
		out.println("你是第"+count+"次访问");
		
	}

}
