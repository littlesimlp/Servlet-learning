package com.qf.entity;



//��ҳ���а�����Щ����
public class EmpPage {
    private int currentPage=1;//��ǰҳ Ĭ��ֵΪ1 
    private int pageSize=3;//ÿҳ��ʾ������¼����
    private int begin;//ÿҳ����ʼλ��
    private int totalPage;//��ҳ��
    private int rows;//�ܼ�¼����
    
    //�ѹ����ܵ�����
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
		//��ҳ�� =������%ÿҳ����¼����	
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
