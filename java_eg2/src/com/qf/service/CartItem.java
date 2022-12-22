package com.qf.service;

import com.qf.entity.Computer;

//商品条目类  记录着对应商品的名称及 购买数量

public class CartItem {
	private Computer c;//记录购买的商品信息
	private int qty;// 记录着购买的商品的数量
	public Computer getC() {
		return c;
	}
	public void setC(Computer c) {
		this.c = c;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
