package com.qf.entity;

public class Emp {
	//�������� ����Ҫ���Ӧ�����ݱ��һ��
	private int id;
	private String uname;
	private String realname;
	private String pwd;
	private double salary;
	private int age;
	//Ϊʵ����������޲������췽��
	public Emp(){}
	//���get ��  set����
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//���hashCode ��equals����
	@Override
	public int hashCode() {
		//�����������equals�Ƚ�Ϊ true��  ���������hashCode ֵһ����ͬ
		//�����������hashCodeֵ��ͬ��  ���������equal�ȽϽ����һ��Ϊtrue
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		//�Է���    �Լ����Լ��ȵ�ʱ�� �ȵ��Ľ��ҪΪtrue
		//������    �����Ƚ϶�εĽ�� Ӧ������ͬ��
		//������    A��B �Ƚ� ���Ϊtrue  B ��C�ȽϽ��Ϊtrue ��ô  A ��C �ȽϽ��Ҳһ��Ϊtrue
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		return true;
	}
	//���һ�� toString ���� ���ڲ�����
	@Override
	public String toString() {
		return "Emp [id=" + id + ", uname=" + uname + ", realname=" + realname + ", pwd=" + pwd + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	
}







