package com.qf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.dao.ComputerDao;
import com.qf.entity.Computer;
import com.qf.service.Cart;
import com.qf.service.CartItem;

public class ActionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComputerDao dao=new ComputerDao();
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if(path.equals("/list")){
			List<Computer>cs=dao.findAll();
			request.setAttribute("cs", cs);
			request.getRequestDispatcher("computer_list.jsp").forward(request, response);
		}else if(path.equals("/buy")){
			int id=Integer.parseInt(request.getParameter("id"));
			//���ݿͻ����ݹ�������Ʒid �����ݿ��в�Ѱ���û��������Ʒ��Ϣ����װ��һ�����󷵻�
			Computer c=dao.findById(id);
			//����һ����Ʒ��Ŀ����
			CartItem item=new CartItem();
			//���û��������Ʒ���뵽��Ʒ��Ŀ����
			item.setC(c);
			//���øù���Ĳ�Ʒ����
			item.setQty(1);
			//��ȡSession����
			HttpSession session=request.getSession();
			//��session�л�ȡ���ﳵ���� ������ǵ�һ�ι���session��û�й��ﳵ����
			//��Ϊ�䴴��һ�����ﳵ����
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null){
				//����ǵ�һ�ι��� ��Ҫ�ȴ�����һ��cart���� Ȼ��󶨵�session������
				cart=new Cart();
				session.setAttribute("cart",cart);
			}
			boolean flag=cart.add(item);
			
			if(!flag){
				//����Ʒ�Ѿ�������� ��ʾ�û��Ѿ���������Ʒ
				request.setAttribute("buy_error"+id, "�Ѿ����������Ʒ��");
				request.getRequestDispatcher("list.do").forward(request, response);
			}else{
				//û����������ص���Ʒ�б�
				request.setAttribute("buy_error"+id, "��ӹ��ﳵ�ɹ�");
				request.getRequestDispatcher("list.do").forward(request, response);
			}
		}else if(path.equals("/update")){
			int id=Integer.parseInt(request.getParameter("id"));
			int qty=Integer.parseInt(request.getParameter("qty"));
			HttpSession session=request.getSession();
			//��session�л�ȡ���ﳵ���� ������ǵ�һ�ι���session��û�й��ﳵ����
			//��Ϊ�䴴��һ�����ﳵ����
			Cart cart=(Cart)session.getAttribute("cart");
			cart.update(id, qty);
			response.sendRedirect("cart.jsp");
		}else if(path.equals("/del")){
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			//��session�л�ȡ���ﳵ���� ������ǵ�һ�ι���session��û�й��ﳵ����
			//��Ϊ�䴴��һ�����ﳵ����
			Cart cart=(Cart)session.getAttribute("cart");
			cart.delete(id);
			response.sendRedirect("cart.jsp");
		}else if(path.equals("/clear")){
			HttpSession session=request.getSession();
			//��session�л�ȡ���ﳵ���� ������ǵ�һ�ι���session��û�й��ﳵ����
			//��Ϊ�䴴��һ�����ﳵ����
			Cart cart=(Cart)session.getAttribute("cart");
			cart.clear();
			response.sendRedirect("cart.jsp");
		}
		
		
	}

}
