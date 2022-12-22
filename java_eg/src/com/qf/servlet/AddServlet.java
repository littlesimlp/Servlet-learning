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
		//���ñ����ʽΪutf-8 ��ֹ��������
		request.setCharacterEncoding("utf-8");
		//��ȡǰ����������ݹ�����Ա����Ϣ
		String uname=request.getParameter("uname");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		//����ȡ��ǰ�˴��ݵĲ�����װ��Emp������
		Emp emp=new Emp();
		emp.setUname(uname);
		emp.setRealname(name);
		emp.setPwd(pwd);
		emp.setSalary(salary);
		emp.setAge(age);
		//����ҵ����add ��ӷ���  ��������ӵ����ݿ���
		EmpService service=new EmpService();
		service.add(emp);
		//��ӳɹ���ҳ���ض���� ��Ϣչʾҳ
		response.sendRedirect("list");
		
	}

}





