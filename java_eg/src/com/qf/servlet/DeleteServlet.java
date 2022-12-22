package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.EmpService;

public class DeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//服务端获取浏览器端传递的参数 
		int id=Integer.parseInt(request.getParameter("id"));
		
		//调用业务层的代码
		EmpService service=new EmpService();
		service.delete(id);
		//跳转回 列表显示页面
		//使用重定向技术 完成页面的跳转
		response.sendRedirect("list");
		
	}

}
