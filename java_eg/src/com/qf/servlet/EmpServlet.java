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
		// 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 获取Session对象
		HttpSession session = request.getSession();

		// 获取浏览器端的请求路径
		String uri = request.getRequestURI();
		// 将获取的请求资源路径uri进行字符串切割处理
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		// 创建业务类型实例对象
		EmpService service = new EmpService();
		// 根据处理后的字符串来判断用户的请求
		if (path.equals("/list")) {
			String age = request.getParameter("age");

			// 获取浏览器端传递的参数 要查询的页数
			String current = request.getParameter("current");
			// 创建一个分页信息
			EmpPage page = new EmpPage();
			if (age != null) {
				// 说明用户搜索时 提交了数据
				// 将搜索条件 放入到EmpPage对象中
				if (age.length() != 0) {
					page.setAge(Integer.parseInt(age));
				}
			}

			// 查询总记录行数
			int rows = service.findRows(page);
			// 将查询出的总行数 添加到 page当中
			page.setRows(rows);
			// 判断current的值是否为null值 如果不是 null
			if (current != null) {
				int cur = Integer.parseInt(current);
				page.setCurrentPage(cur);
			}
			// 调用业务层的代码 获取所有的员工信息
			List<Emp> emps = service.findByPage(page);
			// 将查询到的数据 传递给视图页面 由视图页面将数据返回给浏览器 展示在用户面前
			// step1 先将数据绑定到request对象上
			request.setAttribute("emps", emps);
			request.setAttribute("page", page);
			// step2 获取转发器
			RequestDispatcher dis = request.getRequestDispatcher("empList.jsp");
			// step3 转发
			dis.forward(request, response);
		} else if (path.equals("/add")) {
			// 获取前端浏览器传递过来的员工信息
			String uname = request.getParameter("uname");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			// 将获取的前端传递的参数封装到Emp对象当中
			Emp emp = new Emp();
			emp.setUname(uname);
			emp.setRealname(name);
			emp.setPwd(pwd);
			emp.setSalary(salary);
			emp.setAge(age);
			service.add(emp);
			// 添加成功后将页面重定向会 信息展示页
			response.sendRedirect("list.do");
		} else if (path.equals("/del")) {
			// 服务端获取浏览器端传递的参数
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);
			// 跳转回 列表显示页面
			// 使用重定向技术 完成页面的跳转
			response.sendRedirect("list.do");

		} else if (path.equals("/toUpdate")) {
			// 获取前端产地过来的id值
			int id = Integer.parseInt(request.getParameter("id"));
			Emp emp = service.findById(id);
			// 将查询出的数据绑定到request对象中
			request.setAttribute("emp", emp);
			// 转发到empUpdate.jsp页面
			request.getRequestDispatcher("empUpdate.jsp").forward(request, response);

		} else if (path.equals("/update")) {
			// 获取请求参数
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double salary = Double.parseDouble(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			// 封装数据
			Emp emp = new Emp();
			emp.setId(id);
			emp.setRealname(name);
			emp.setSalary(salary);
			emp.setAge(age);
			service.update(emp);
			// 重定向回列表显示页面
			response.sendRedirect("list.do");
		} else if (path.equals("/login")) {
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String ck = request.getParameter("number");
			Emp emp = service.login(uname);
			request.setAttribute("uname", uname);
			if (emp == null) {
				// 说明数据库中没有与该用户名对应的数据用户名错误
				request.setAttribute("umsg", "用户名错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			if (!emp.getPwd().equals(pwd)) {
				// 说明密码错误
				request.setAttribute("pmsg", "密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			// 从session当中将CheckCodeServlet中绑定的验证码取出
			String ck2 = (String) session.getAttribute("ck");
			// 将前端页面传递过来的验证码与后台生成的验证码进行比较
			if (!ck.equals(ck2)) {
				// 说明验证码错误
				request.setAttribute("ckmsg", "验证码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}

			// 用户名和密码验证都没有问题后,将登录对象的数据绑定到session对象中
			session.setAttribute("e", emp);
			// 如果上述两个条件都没有触发 说明用户名和密码正确
			response.sendRedirect("list.do");
		}

	}

}
