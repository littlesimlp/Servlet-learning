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
		//������������ı����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ�������
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		//��װ����
		Emp emp=new Emp();
		emp.setId(id);
		emp.setRealname(name);
		emp.setSalary(salary);
		emp.setAge(age);
		//����ҵ������
		EmpService service=new EmpService();
		service.update(emp);
		//�ض�����б���ʾҳ��
		response.sendRedirect("list");
	}

}




