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
	
	//��ѯ�������ݵķ���
	public List<Emp> findAll(){
		//����һ�����϶���
		List<Emp>emps=new ArrayList<Emp>();
		//��ȡ���ݿ����Ӷ���
		Connection con=DBUtil.getConnection();
		//����sql���
		String sql="select * from emp";	
		try {
			//��ȡPreparedStatment����  ����������ݿ�sql���
			PreparedStatement prep=con.prepareStatement(sql);
			//ִ��sql���  ��ȡ��ѯ���ݺ�Ľ��������
			ResultSet rs=prep.executeQuery();
			//������������� ����ѯ��������ݷ�װ��Emp������  
			while(rs.next()){
				Emp emp=new Emp();
				emp.setId(rs.getInt("id"));
				emp.setUname(rs.getString("uname"));
				emp.setRealname(rs.getString("realname"));
				emp.setPwd(rs.getString("pwd"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setAge(rs.getInt("age"));
				//����װ�õ�emp���� ��ӵ�list������
				emps.add(emp);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return emps;
	}

	//ɾ��ĳ��Ա����Ϣ
	public void delete(int id){
		//�������ݿ�
		Connection con=DBUtil.getConnection();
		//����sql���
		String sql="delete from emp where id=?";
		try {
			//��ȡPreparedStatement����
			PreparedStatement prep=con.prepareStatement(sql);
			//�����ݵĲ��� ע�뵽ռλ����
			prep.setInt(1, id);
			//ִ��sql���,ִ�в�ѯʱ ����executeQuery  ִ��ɾ�� ��� �޸�ʱ����executeUpdate
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//���Ա����Ϣ
	public void add(Emp emp){
		//��ȡ���ݿ�����
		Connection con=DBUtil.getConnection();
		//����sql
		String sql="insert into emp(uname,realname,pwd,salary,age)values(?,?,?,?,?)";	
		try {
			//��ȡPreparedStatement����
			PreparedStatement prep=con.prepareStatement(sql);
			//���ռλ������
			prep.setString(1,emp.getUname());
			prep.setString(2, emp.getRealname());
			prep.setString(3,emp.getPwd());
			prep.setDouble(4, emp.getSalary());
			prep.setInt(5, emp.getAge());
			//ִ��sql
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//����id��ѯĳ��Ա������Ϣ
	public Emp findById(int id){
		Emp emp=null;
		//��ȡ���ݿ�����
		Connection con=DBUtil.getConnection();
		//����sql
		String sql="select * from emp where id=?";
		try {
			//��ȡPreparedStatement����
			PreparedStatement prep=con.prepareStatement(sql);
			//ע��ռλ������
			prep.setInt(1, id);
			//ִ��sql��ȡ���������
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
	
	//�޸ķ���
	public void update(Emp emp){
		//��ȡ���Ӷ���
		Connection con=DBUtil.getConnection();
		//����sql���
		String sql="update emp set realname=?,salary=?,age=? where id=?";
		try {
			//��ȡPreparedStatment����
			PreparedStatement prep=con.prepareStatement(sql);
			//Ϊռλ����ע�����
			prep.setString(1, emp.getRealname());
			prep.setDouble(2, emp.getSalary());
			prep.setInt(3, emp.getAge());
			prep.setInt(4, emp.getId());
			//ִ��sql
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//��ҳ��ѯ
	public List<Emp> findByPage(EmpPage page){
		List<Emp>emps=new ArrayList<Emp>();
		//�������ݿ� 
		Connection con=DBUtil.getConnection();
		if(page.getAge()==null){
			//����sql���
			String sql="select * from emp limit ?,?";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setInt(1, page.getBegin());
				prep.setInt(2, page.getPageSize());
				ResultSet rs=prep.executeQuery();
				//������������� ����ѯ��������ݷ�װ��Emp������  
				while(rs.next()){
					Emp emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setUname(rs.getString("uname"));
					emp.setRealname(rs.getString("realname"));
					emp.setPwd(rs.getString("pwd"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setAge(rs.getInt("age"));
					//����װ�õ�emp���� ��ӵ�list������
					emps.add(emp);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emps;	
		}else{

			//����sql���
			String sql="select * from emp where age=? limit ?,?";
			try {
				PreparedStatement prep=con.prepareStatement(sql);
				prep.setInt(1, page.getAge());
				prep.setInt(2, page.getBegin());
				prep.setInt(3, page.getPageSize());
				ResultSet rs=prep.executeQuery();
				//������������� ����ѯ��������ݷ�װ��Emp������  
				while(rs.next()){
					Emp emp=new Emp();
					emp.setId(rs.getInt("id"));
					emp.setUname(rs.getString("uname"));
					emp.setRealname(rs.getString("realname"));
					emp.setPwd(rs.getString("pwd"));
					emp.setSalary(rs.getDouble("salary"));
					emp.setAge(rs.getInt("age"));
					//����װ�õ�emp���� ��ӵ�list������
					emps.add(emp);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return emps;	
		
		}
		
		
		
	}
	
	//��ѯ�ܼ�¼����
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
	//�����û�����ѯ�û���Ϣ
	public Emp findByUserName(String uname){

		Emp emp=null;
		//��ȡ���ݿ�����
		Connection con=DBUtil.getConnection();
		//����sql
		String sql="select * from emp where uname=?";
		try {
			//��ȡPreparedStatement����
			PreparedStatement prep=con.prepareStatement(sql);
			//ע��ռλ������
			prep.setString(1, uname);
			//ִ��sql��ȡ���������
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





