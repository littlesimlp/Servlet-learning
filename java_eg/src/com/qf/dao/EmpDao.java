package com.qf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qf.entity.Emp;
import com.qf.entity.EmpPage;
import com.qf.util.DBUtil;

public class EmpDao {
	
	//查询所有数据的方法
	public List<Emp> findAll(){
		//定义一个集合对象
		List<Emp>emps=new ArrayList<Emp>();
		//获取数据库链接对象
		Connection con=DBUtil.getConnection();
		//定义sql语句
		String sql="select * from emp";	
		try {
			//获取PreparedStatment对象  负责操作数据库sql语句
			PreparedStatement prep=con.prepareStatement(sql);
			//执行sql语句  获取查询数据后的结果集对象
			ResultSet rs=prep.executeQuery();
			//迭代结果集对象 将查询输出的数据封装到Emp对象当中  
			while(rs.next()){
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setUname(rs.getString("uname"));
				emp.setRealname(rs.getString("realname"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				//将封装好的emp对象 添加到list集合中
				emps.add(emp);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return emps;
	}

	//删除某个员工信息
	public void delete(int id){
		//链接数据库
		Connection con=DBUtil.getConnection();
		//定义sql语句
		String sql="delete from emp where id=?";
		try {
			//获取PreparedStatement对象
			PreparedStatement prep=con.prepareStatement(sql);
			//将传递的参数 注入到占位符中
			prep.setInt(1, id);
			//执行sql语句,执行查询时 调用executeQuery  执行删除 添加 修改时调用executeUpdate
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//添加员工信息
	public void add(Emp emp){
		//获取数据库链接
		Connection con=DBUtil.getConnection();
		//定义sql
		String sql="insert into emp(uname,realname,pwd,salary,age)values(?,?,?,?,?)";	
		try {
			//获取PreparedStatement对象
			PreparedStatement prep=con.prepareStatement(sql);
			//添加占位符参数
			prep.setString(1,emp.getUname());
			prep.setString(2, emp.getRealname());
			prep.setString(3,emp.getPwd());
			prep.setDouble(4, emp.getSalary());
			prep.setInt(5, emp.getAge());
			//执行sql
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//根基id查询某个员工的信息
	public Emp findById(int id){
		Emp emp=null;
		//获取数据库链接
		Connection con=DBUtil.getConnection();
		//定义sql
		String sql="select * from emp where id=?";
		try {
			//获取PreparedStatement对象
			PreparedStatement prep=con.prepareStatement(sql);
			//注入占位符参数
			prep.setInt(1, id);
			//执行sql获取结果集对象
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setUname(rs.getString("uname"));
				emp.setRealname(rs.getString("realname"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	
	//修改方法
	public void update(Emp emp){
		//获取链接对象
		Connection con=DBUtil.getConnection();
		//定义sql语句
		String sql="update emp set realname=?,salary=?,age=? where id=?";
		try {
			//获取PreparedStatment对象
			PreparedStatement prep=con.prepareStatement(sql);
			//为占位符号注入参数
			prep.setString(1, emp.getRealname());
			prep.setDouble(2, emp.getSalary());
			prep.setInt(3, emp.getAge());
			prep.setInt(4, emp.getId());
			//执行sql
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//分页查询
	public List<Emp> findByPage(EmpPage page){
		List<Emp>emps=new ArrayList<Emp>();
		//链接数据库 
		Connection con=DBUtil.getConnection();
		if(page.getAge()==null){
			//定义sql语句
			String sql="select * from emp limit ?,?";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setInt(1, page.getBegin());
				prep.setInt(2, page.getPageSize());
				ResultSet rs=prep.executeQuery();
				//迭代结果集对象 将查询输出的数据封装到Emp对象当中  
				while(rs.next()){
					Emp emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setUname(rs.getString("uname"));
					emp.setRealname(rs.getString("realname"));
					emp.setPwd(rs.getString("pwd"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setAge(rs.getInt("age"));
					//将封装好的emp对象 添加到list集合中
					emps.add(emp);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emps;	
		}else{

			//定义sql语句
			String sql="select * from emp where age=? limit ?,?";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setInt(1, page.getAge());
				prep.setInt(2, page.getBegin());
				prep.setInt(3, page.getPageSize());
				ResultSet rs=prep.executeQuery();
				//迭代结果集对象 将查询输出的数据封装到Emp对象当中  
				while(rs.next()){
					Emp emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setUname(rs.getString("uname"));
					emp.setRealname(rs.getString("realname"));
					emp.setPwd(rs.getString("pwd"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setAge(rs.getInt("age"));
					//将封装好的emp对象 添加到list集合中
					emps.add(emp);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emps;	
		
		}
		
		
		
	}
	
	//查询总记录行数
	public int findRows(EmpPage page){
		int count=0;
		Connection con=DBUtil.getConnection();
		
		if(page.getAge()==null){

			String sql="select count(*) c from emp";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				ResultSet rs=prep.executeQuery();
				if(rs.next()){
					count=rs.getInt("c");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;
			
		}else{


			String sql="select count(*) c from emp where age=?";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setInt(1,page.getAge());
				ResultSet rs=prep.executeQuery();
				
				if(rs.next()){
					count=rs.getInt("c");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return count;
			
		
		}
		
		
	}
	//根据用户名查询用户信息
	public Emp findByUserName(String uname){

		Emp emp=null;
		//获取数据库链接
		Connection con=DBUtil.getConnection();
		//定义sql
		String sql="select * from emp where uname=?";
		try {
			//获取PreparedStatement对象
			PreparedStatement prep=con.prepareStatement(sql);
			//注入占位符参数
			prep.setString(1, uname);
			//执行sql获取结果集对象
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
				emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setUname(rs.getString("uname"));
				emp.setRealname(rs.getString("realname"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
}





