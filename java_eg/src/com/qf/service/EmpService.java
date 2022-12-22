package com.qf.service;

import java.util.List;

import com.qf.dao.EmpDao;
import com.qf.entity.Emp;
import com.qf.entity.EmpPage;

//Ա������ϵͳ��ҵ������

public class EmpService {

	private EmpDao dao=new EmpDao();
	//���ҵ����� ��Ҫ����Dao������ݷ����߼�ʵ��
	//չʾ�û���Ϣ
	public List<Emp> list(){
		return dao.findAll();
	}
	//ɾ��Ա����Ϣ�ķ���
	public void delete(int id){
		dao.delete(id);
	}
	//���Ա����Ϣ
	public void add(Emp emp){
		dao.add(emp);
	}
	
	//��ѯĳ��Ա����Ϣ
	public Emp findById(int id){
		Emp emp=dao.findById(id);
		return emp;
	}
	
	//�޸���Ϣ
	public void update(Emp emp){
		dao.update(emp);
	}
	//��ѯ��ҳ��Ϣ
	public List<Emp> findByPage(EmpPage page){
		return dao.findByPage(page);
	}
	//��ѯ�ܼ�¼����
	public int findRows(EmpPage page){
		return dao.findRows(page);
	}
	
	//��¼����
	public Emp login(String uname){
		return dao.findByUserName(uname);
	}
	
}






