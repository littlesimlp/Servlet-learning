package com.qf.util;
import java.sql.Connection;
import java.sql.DriverManager;

//数据库链接的工具类型

public class DBUtil {
	
	//5.0版本获取数据库链接	
	public static Connection getConnection(){
		Connection con=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库的链接
			String url="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8";
			String name="root";
			String pwd="123456";
			con=DriverManager.getConnection(url,name,pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	   //8.0版本获取数据库链接	
		public static Connection getConnection2(){
			Connection con=null;
			try {
				//加载驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				//获取数据库的链接
				String url="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&serverTimezone=UTC";
				String name="root";
				String pwd="123456";
				con=DriverManager.getConnection(url,name,pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
	
}
