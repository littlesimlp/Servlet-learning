package com.qf.service;

import java.util.List;

import com.qf.dao.EmpDao;
import com.qf.entity.Emp;
import com.qf.entity.EmpPage;

//员工管理系统的业务层代码

public class EmpService {

	private EmpDao dao=new EmpDao();
	//完成业务代码 需要调用Dao层的数据访问逻辑实现
	//展示用户信息
	public List<Emp> list(){
		return dao.findAll();
	}
	//删除员工信息的方法
	public void delete(int id){
		dao.delete(id);
	}
	//添加员工信息
	public void add(Emp emp){
		dao.add(emp);
	}
	
	//查询某个员工信息
	public Emp findById(int id){
		Emp emp=dao.findById(id);
		return emp;
	}
	
	//修改信息
	public void update(Emp emp){
		dao.update(emp);
	}
	//查询分页信息
	public List<Emp> findByPage(EmpPage page){
		return dao.findByPage(page);
	}
	//查询总记录行数
	public int findRows(EmpPage page){
		return dao.findRows(page);
	}
	
	//登录方法
	public Emp login(String uname){
		return dao.findByUserName(uname);
	}
	
}






