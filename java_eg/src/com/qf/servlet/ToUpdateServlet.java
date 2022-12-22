package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Emp;
import com.qf.service.EmpService;

public class ToUpdateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //获取前端产地过来的id值
		 int id=Integer.parseInt(request.getParameter("id"));
		 //根据id 查询出对应的信息
		 EmpService service=new EmpService();
		 Emp emp=service.findById(id);
		 //将查询出的数据绑定到request对象中
		 request.setAttribute("emp", emp);
		 //转发到empUpdate.jsp页面
		 request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
		 
	}

}
