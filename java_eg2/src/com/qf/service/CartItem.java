package com.qf.service;

import com.qf.entity.Computer;

//��Ʒ��Ŀ��  ��¼�Ŷ�Ӧ��Ʒ�����Ƽ� ��������

public class CartItem {
	private Computer c;//��¼�������Ʒ��Ϣ
	private int qty;// ��¼�Ź������Ʒ������
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
