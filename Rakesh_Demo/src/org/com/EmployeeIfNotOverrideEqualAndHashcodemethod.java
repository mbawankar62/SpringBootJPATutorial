package org.com;

import java.util.HashMap;
import java.util.Map;

public class EmployeeIfNotOverrideEqualAndHashcodemethod {

	public static void main(String[] args) {

		Map<Employee, String> hm = new HashMap<>();
		
		Employee e1 = new Employee(1, "Rakesh", "SD");
		Employee e2 = new Employee(1, "Rakesh", "SD");
		Employee e3 = new Employee(1, "Rakesh", "SD");
		Employee e4 = new Employee(1, "Rakesh", "SD");
		
		hm.put(e1, "A");
		hm.put(e2, "B");
		hm.put(e3, "C");
		hm.put(e4, "D");
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());
		
		System.out.println(hm.get(e1));
		System.out.println(hm.size());
		System.out.println(hm.toString());
	}

}
