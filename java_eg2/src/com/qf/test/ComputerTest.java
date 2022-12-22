package com.qf.test;

import java.util.List;

import com.qf.dao.ComputerDao;
import com.qf.entity.Computer;

public class ComputerTest {

	public static void main(String[] args) {
		ComputerDao dao=new ComputerDao();
		//System.out.println(dao.findById(1));
		List<Computer>cs=dao.findAll();
		System.out.println(cs);
		for(Computer c:cs){
			System.out.println(c);
		}

	}

}
