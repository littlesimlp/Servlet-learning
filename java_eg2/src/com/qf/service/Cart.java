package com.qf.service;

import java.util.ArrayList;
import java.util.List;

//购物车类
public class Cart {
	//商品条目类型
	private List<CartItem> items=new ArrayList<>();
 
	//添加购物车
	public boolean add(CartItem item){
		//先判断一下这个商品有没有购买过 如果买过返回false  没有买过 返回true 并将商品加如到购物车当中
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==item.getC().getId()){
				//已经购买过该商品了
				return false;
			}
		}
		items.add(item);
		return true;
	}
	
	//获取购物车中所有商品条目
	public List<CartItem>list(){
		return items;
	}
	//修改购物车中商品数量方法
	public void update(int id,int qty){
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==id){
				curr.setQty(qty);
				return;
			}
		}
	}
	//删除商品条目
	public void delete(int id){
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			if(curr.getC().getId()==id){
				items.remove(curr);
				return;
			}
		}
		
		
	}
	
	//清空购物车中的所有商品
	public void clear(){
		items.clear();
	}
	//统计总价格
	public double total(){
		double total=0;
		for(int i=0;i<items.size();i++){
			CartItem curr=items.get(i);
			total+=curr.getC().getPrice()*curr.getQty();
		}
		
		return total;
	}
	
 
}









