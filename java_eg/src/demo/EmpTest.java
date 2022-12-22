package demo;

import java.util.HashSet;
import java.util.Set;

public class EmpTest {

	public static void main(String[] args) {
		Emp emp1=new Emp();
		emp1.setId(1);
		emp1.setName("zs");
		Emp emp2=new Emp();
		emp2.setId(1);
		emp2.setName("zs");
		Set s=new HashSet();
		s.add(emp1);
		s.add(emp2);
		System.out.println(s);

	}

}
