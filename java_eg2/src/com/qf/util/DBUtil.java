package com.qf.util;
import java.sql.Connection;
import java.sql.DriverManager;

//���ݿ����ӵĹ�������

public class DBUtil {
	
	//5.0�汾��ȡ���ݿ�����	
	public static Connection getConnection(){
		Connection con=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ���ݿ������
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
	
	   //8.0�汾��ȡ���ݿ�����	
		public static Connection getConnection2(){
			Connection con=null;
			try {
				//��������
				Class.forName("com.mysql.cj.jdbc.Driver");
				//��ȡ���ݿ������
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
