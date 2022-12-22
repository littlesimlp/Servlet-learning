package com.qf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.entity.Emp;
import com.qf.service.EmpService;

public class AddServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式为utf-8 防止中文乱码
		request.setCharacterEncoding("utf-8");
		//获取前端浏览器传递过来的员工信息
		String uname=request.getParameter("uname");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		//将获取的前端传递的参数封装到Emp对象当中
		Emp emp=new Emp();
		emp.setUname(uname);
		emp.setRealname(name);
		emp.setPwd(pwd);
		emp.setSalary(salary);
		emp.setAge(age);
		//调用业务层的add 添加方法  将数据添加到数据库中
		EmpService service=new EmpService();
		service.add(emp);
		//添加成功后将页面重定向会 信息展示页
		response.sendRedirect("list");
		
	}

}





