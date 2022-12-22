package com.qf.entity;



//分页当中包含哪些数据
public class EmpPage {
    private int currentPage=1;//当前页 默认值为1 
    private int pageSize=3;//每页显示的最大记录条数
    private int begin;//每页的起始位置
    private int totalPage;//总页数
    private int rows;//总记录行数
    
    //搜过功能的条件
    private Integer age=null;
    
    
    

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public int getCurrentPage() {
		
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getBegin() {
		begin=(this.currentPage-1)*pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getTotalPage() {
		//总页数 =总行数%每页最大记录行数	
		totalPage=rows%pageSize==0?rows/pageSize:rows/pageSize+1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
    
    
	
}
