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
		//����˻�ȡ������˴��ݵĲ��� 
		int id=Integer.parseInt(request.getParameter("id"));
		
		//����ҵ���Ĵ���
		EmpService service=new EmpService();
		service.delete(id);
		//��ת�� �б���ʾҳ��
		//ʹ���ض����� ���ҳ�����ת
		response.sendRedirect("list");
		
	}

}
