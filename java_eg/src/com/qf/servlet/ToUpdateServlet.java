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
		 //��ȡǰ�˲��ع�����idֵ
		 int id=Integer.parseInt(request.getParameter("id"));
		 //����id ��ѯ����Ӧ����Ϣ
		 EmpService service=new EmpService();
		 Emp emp=service.findById(id);
		 //����ѯ�������ݰ󶨵�request������
		 request.setAttribute("emp", emp);
		 //ת����empUpdate.jspҳ��
		 request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
		 
	}

}
