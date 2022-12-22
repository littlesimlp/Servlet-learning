package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.entity.Emp;
import com.qf.entity.EmpPage;
import com.qf.service.EmpService;

public class EmpServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		// ��ȡSession����
		HttpSession session = request.getSession();

		// ��ȡ������˵�����·��
		String uri = request.getRequestURI();
		// ����ȡ��������Դ·��uri�����ַ����и��
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		// ����ҵ������ʵ������
		EmpService service = new EmpService();
		// ���ݴ������ַ������ж��û�������
		if (path.equals("/list")) {
			String age = request.getParameter("age");

			// ��ȡ������˴��ݵĲ��� Ҫ��ѯ��ҳ��
			String current = request.getParameter("current");
			// ����һ����ҳ��Ϣ
			EmpPage page = new EmpPage();
			if (age != null) {
				// ˵���û�����ʱ �ύ������
				// ���������� ���뵽EmpPage������
				if (age.length() != 0) {
					page.setAge(Integer.parseInt(age));
				}
			}

			// ��ѯ�ܼ�¼����
			int rows = service.findRows(page);
			// ����ѯ���������� ��ӵ� page����
			page.setRows(rows);
			// �ж�current��ֵ�Ƿ�Ϊnullֵ ������� null
			if (current != null) {
				int cur = Integer.parseInt(current);
				page.setCurrentPage(cur);
			}
			// ����ҵ���Ĵ��� ��ȡ���е�Ա����Ϣ
			List<Emp> emps = service.findByPage(page);
			// ����ѯ�������� ���ݸ���ͼҳ�� ����ͼҳ�潫���ݷ��ظ������ չʾ���û���ǰ
			// step1 �Ƚ����ݰ󶨵�request������
			request.setAttribute("emps", emps);
			request.setAttribute("page", page);
			// step2 ��ȡת����
			RequestDispatcher dis = request.getRequestDispatcher("empList.jsp");
			// step3 ת��
			dis.forward(request, response);
		} else if (path.equals("/add")) {
			// ��ȡǰ����������ݹ�����Ա����Ϣ
			String uname = request.getParameter("uname");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			// ����ȡ��ǰ�˴��ݵĲ�����װ��Emp������
			Emp emp = new Emp();
			emp.setUname(uname);
			emp.setRealname(name);
			emp.setPwd(pwd);
			emp.setSalary(salary);
			emp.setAge(age);
			service.add(emp);
			// ��ӳɹ���ҳ���ض���� ��Ϣչʾҳ
			response.sendRedirect("list.do");
		} else if (path.equals("/del")) {
			// ����˻�ȡ������˴��ݵĲ���
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);
			// ��ת�� �б���ʾҳ��
			// ʹ���ض����� ���ҳ�����ת
			response.sendRedirect("list.do");

		} else if (path.equals("/toUpdate")) {
			// ��ȡǰ�˲��ع�����idֵ
			int id = Integer.parseInt(request.getParameter("id"));
			Emp emp = service.findById(id);
			// ����ѯ�������ݰ󶨵�request������
			request.setAttribute("emp", emp);
			// ת����empUpdate.jspҳ��
			request.getRequestDispatcher("empUpdate.jsp").forward(request, response);

		} else if (path.equals("/update")) {
			// ��ȡ�������
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			// ��װ����
			Emp emp = new Emp();
			emp.setId(id);
			emp.setRealname(name);
			emp.setSalary(salary);
			emp.setAge(age);
			service.update(emp);
			// �ض�����б���ʾҳ��
			response.sendRedirect("list.do");
		} else if (path.equals("/login")) {
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String ck = request.getParameter("number");
			Emp emp = service.login(uname);
			request.setAttribute("uname", uname);
			if (emp == null) {
				// ˵�����ݿ���û������û�����Ӧ�������û�������
				request.setAttribute("umsg", "�û�������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			if (!emp.getPwd().equals(pwd)) {
				// ˵���������
				request.setAttribute("pmsg", "�������");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			// ��session���н�CheckCodeServlet�а󶨵���֤��ȡ��
			String ck2 = (String) session.getAttribute("ck");
			// ��ǰ��ҳ�洫�ݹ�������֤�����̨���ɵ���֤����бȽ�
			if (!ck.equals(ck2)) {
				// ˵����֤�����
				request.setAttribute("ckmsg", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			// �û�����������֤��û�������,����¼��������ݰ󶨵�session������
			session.setAttribute("e", emp);
			// �����������������û�д��� ˵���û�����������ȷ
			response.sendRedirect("list.do");
		}

	}

}
