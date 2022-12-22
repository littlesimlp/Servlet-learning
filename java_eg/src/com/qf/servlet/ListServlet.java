package com.qf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Emp;
import com.qf.service.EmpService;


public class ListServlet extends HttpServlet {

	private EmpService service=new EmpService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//调用业务层的代码  获取所有的员工信息
		List<Emp>emps=service.list();
		//将查询到的数据 传递给视图页面  由视图页面将数据返回给浏览器 展示在用户面前
		//step1  先将数据绑定到request对象上
		request.setAttribute("emps", emps);
		//step2 获取转发器
		RequestDispatcher dis=request.getRequestDispatcher("empList.jsp");
		//step3 转发
		dis.forward(request, response);
	}

}






