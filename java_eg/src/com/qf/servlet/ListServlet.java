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
		//����ҵ���Ĵ���  ��ȡ���е�Ա����Ϣ
		List<Emp>emps=service.list();
		//����ѯ�������� ���ݸ���ͼҳ��  ����ͼҳ�潫���ݷ��ظ������ չʾ���û���ǰ
		//step1  �Ƚ����ݰ󶨵�request������
		request.setAttribute("emps", emps);
		//step2 ��ȡת����
		RequestDispatcher dis=request.getRequestDispatcher("empList.jsp");
		//step3 ת��
		dis.forward(request, response);
	}

}






