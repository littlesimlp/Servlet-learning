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
	//��ѯ������Ʒ�б�
	public List<Computer> findAll(){

		//����һ�����϶���
		List<Computer> coms=new ArrayList<Computer>();
		//��ȡ���ݿ����Ӷ���
		Connection con=DBUtil.getConnection();
		//����sql���
		String sql="select * from computer";	
		try {
			//��ȡPreparedStatment����  ����������ݿ�sql���
			PreparedStatement prep=con.prepareStatement(sql);
			//ִ��sql���  ��ȡ��ѯ���ݺ�Ľ��������
			ResultSet rs=prep.executeQuery();
			//������������� ����ѯ��������ݷ�װ��Emp������  
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
	//����id��ѯĳ����Ʒ��Ϣ
	public Computer findById(int id){

		Computer c=null;
		//��ȡ���ݿ�����
		Connection con=DBUtil.getConnection();
		//����sql
		String sql="select * from computer where id=?";
		try {
			//��ȡPreparedStatement����
			PreparedStatement prep=con.prepareStatement(sql);
			//ע��ռλ������
			prep.setInt(1, id);
			//ִ��sql��ȡ���������
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




