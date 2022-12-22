package com.qf.service;

import java.util.ArrayList;
import java.util.List;

//���ﳵ��
public class Cart {
	//��Ʒ��Ŀ����
	private List<CartItem> items=new ArrayList<>();
 
	//��ӹ��ﳵ
	public boolean add(CartItem item){
		//���ж�һ�������Ʒ��û�й���� ����������false  û����� ����true ������Ʒ���絽���ﳵ����
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==item.getC().getId()){
				//�Ѿ����������Ʒ��
				return false;
			}
		}
		items.add(item);
		return true;
	}
	
	//��ȡ���ﳵ��������Ʒ��Ŀ
	public List<CartItem>list(){
		return items;
	}
	//�޸Ĺ��ﳵ����Ʒ��������
	public void update(int id,int qty){
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==id){
				curr.setQty(qty);
				return;
			}
		}
	}
	//ɾ����Ʒ��Ŀ
	public void delete(int id){
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==id){
				items.remove(curr);
				return;
			}
		}
		
		
	}
	
	//��չ��ﳵ�е�������Ʒ
	public void clear(){
		items.clear();
	}
	//ͳ���ܼ۸�
	public double total(){
		double total=0;
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			total+=curr.getC().getPrice()*curr.getQty();
		}
		
		return total;
	}
	
 
}









