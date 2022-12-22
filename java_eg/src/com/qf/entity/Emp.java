package com.qf.entity;

public class Emp {
	//定义属性 属性要与对应的数据表格一致
	private int id;
	private String uname;
	private String realname;
	private String pwd;
	private double salary;
	private int age;
	//为实体类型添加无参数构造方法
	public Emp(){}
	//添加get 和  set方法
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
	//添加hashCode 和equals方法
	@Override
	public int hashCode() {
		//当两个对象的equals比较为 true是  两个对象的hashCode 值一定相同
		//当两个对象的hashCode值相同是  两个对象的equal比较结果不一定为true
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		//自反性    自己和自己比的时候 等到的结果要为true
		//永久性    反复比较多次的结果 应该是相同的
		//传递性    A和B 比较 结果为true  B 和C比较结果为true 那么  A 和C 比较结果也一定为true
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
	//添加一个 toString 方法 便于测试用
	@Override
	public String toString() {
		return "Emp [id=" + id + ", uname=" + uname + ", realname=" + realname + ", pwd=" + pwd + ", salary=" + salary
				+ ", age=" + age + "]";
	}
	
}







