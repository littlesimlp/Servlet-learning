package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.Computer;
import com.qf.util.DBUtil;

public class ComputerDao {
	//查询所有商品列表
	public List<Computer> findAll(){

		//定义一个集合对象
		List<Computer> coms=new ArrayList<Computer>();
		//获取数据库链接对象
		Connection con=DBUtil.getConnection();
		//定义sql语句
		String sql="select * from computer";	
		try {
			//获取PreparedStatment对象  负责操作数据库sql语句
			PreparedStatement prep=con.prepareStatement(sql);
			//执行sql语句  获取查询数据后的结果集对象
			ResultSet rs=prep.executeQuery();
			//迭代结果集对象 将查询输出的数据封装到Emp对象当中  
			while(rs.next()){
				Computer c=new Computer();
				c.setId(rs.getInt("id"));
				c.setModel(rs.getString("model"));
				c.setPic(rs.getString("pic"));
				c.setPrice(rs.getDouble("price"));
				c.setProdDesc(rs.getString("prodDesc"));
				coms.add(c);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return coms;
	
	}
	//根据id查询某个商品信息
	public Computer findById(int id){

		Computer c=null;
		//获取数据库链接
		Connection con=DBUtil.getConnection();
		//定义sql
		String sql="select * from computer where id=?";
		try {
			//获取PreparedStatement对象
			PreparedStatement prep=con.prepareStatement(sql);
			//注入占位符参数
			prep.setInt(1, id);
			//执行sql获取结果集对象
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
				c=new Computer();
				c.setId(rs.getInt("id"));
				c.setModel(rs.getString("model"));
				c.setPic(rs.getString("pic"));
				c.setPrice(rs.getDouble("price"));
				c.setProdDesc(rs.getString("prodDesc"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	
	}
	
	
}




