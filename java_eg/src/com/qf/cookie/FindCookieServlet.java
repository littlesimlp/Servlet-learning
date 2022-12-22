package com.qf.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Cookie[] cs= request.getCookies();
		if(cs!=null){
			for(int i =0;i<cs.length;i++){
				Cookie c=cs[i];
				String name=c.getName();
				String value=c.getValue();
				out.println("<h1>name:"+name+" value:"+value+"</h1>");
			}
		}else{
			out.println("Ã»ÓÐcookie");
		}
		out.close();
	}

}
