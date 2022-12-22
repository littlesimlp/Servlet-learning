package com.qf.test;

import java.util.List;

import com.qf.dao.EmpDao;
import com.qf.entity.Emp;
import com.qf.entity.EmpPage;

public class DaoTest {

	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		//≤‚ ‘∑÷“≥
		EmpPage page=new EmpPage();
		page.setCurrentPage(2);
		List<Emp>emps=dao.findByPage(page);
		for(Emp emp:emps){
			System.out.println(emp);
		}
	}

}





