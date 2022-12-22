package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Emp;
import com.qf.service.EmpService;


public class UpdateServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求参数的编码格式
		request.setCharacterEncoding("utf-8");
		//获取请求参数
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		//封装数据
		Emp emp=new Emp();
		emp.setId(id);
		emp.setRealname(name);
		emp.setSalary(salary);
		emp.setAge(age);
		//创建业务层代码
		EmpService service=new EmpService();
		service.update(emp);
		//重定向回列表显示页面
		response.sendRedirect("list");
	}

}




