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
			//根据客户传递过来的商品id 在数据库中查寻出用户购买的商品信息并封装成一个对象返回
			Computer c=dao.findById(id);
			//创建一个商品条目类型
			CartItem item=new CartItem();
			//将用户购买的商品放入到商品条目类中
			item.setC(c);
			//设置该购买的产品数量
			item.setQty(1);
			//获取Session对象
			HttpSession session=request.getSession();
			//到session中获取购物车对象 ，如果是第一次够买session中没有购物车对象
			//会为其创建一个购物车对象
			Cart cart=(Cart)session.getAttribute("cart");
			if(cart==null){
				//如果是第一次购买 需要先创建好一个cart对象 然后绑定到session对象上
				cart=new Cart();
				session.setAttribute("cart",cart);
			}
			boolean flag=cart.add(item);
			
			if(!flag){
				//该商品已经购买过了 提示用户已经买过这个商品
				request.setAttribute("buy_error"+id, "已经购买过该商品了");
				request.getRequestDispatcher("list.do").forward(request, response);
			}else{
				//没有买过，返回到商品列表
				request.setAttribute("buy_error"+id, "添加购物车成功");
				request.getRequestDispatcher("list.do").forward(request, response);
			}
		}else if(path.equals("/update")){
			int id=Integer.parseInt(request.getParameter("id"));
			int qty=Integer.parseInt(request.getParameter("qty"));
			HttpSession session=request.getSession();
			//到session中获取购物车对象 ，如果是第一次够买session中没有购物车对象
			//会为其创建一个购物车对象
			Cart cart=(Cart)session.getAttribute("cart");
			cart.update(id, qty);
			response.sendRedirect("cart.jsp");
		}else if(path.equals("/del")){
			int id=Integer.parseInt(request.getParameter("id"));
			HttpSession session=request.getSession();
			//到session中获取购物车对象 ，如果是第一次够买session中没有购物车对象
			//会为其创建一个购物车对象
			Cart cart=(Cart)session.getAttribute("cart");
			cart.delete(id);
			response.sendRedirect("cart.jsp");
		}else if(path.equals("/clear")){
			HttpSession session=request.getSession();
			//到session中获取购物车对象 ，如果是第一次够买session中没有购物车对象
			//会为其创建一个购物车对象
			Cart cart=(Cart)session.getAttribute("cart");
			cart.clear();
			response.sendRedirect("cart.jsp");
		}
		
		
	}

}
