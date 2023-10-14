package com.mohit.corejava.comparator;

public class Emp2testEquals_Hashcode {

	public static void main(String[] args) {
		// creating two instances of the Employee class
		Emp2 emp1 = new Emp2(918, "Maria");
		Emp2 emp2 = new Emp2(918, "Maria");
		Emp2 emp3 = new Emp2(918, "Mohit");
		// invoking hashCode() method
		int a = emp1.hashCode();
		int b = emp2.hashCode();
		int c = emp3.hashCode();
		System.out.println("hashcode of emp1 = " + a);
		System.out.println("hashcode of emp2 = " + b);
		System.out.println("hashcode of emp3 = " + c);
		System.out.println("Comparing objects emp1 and emp2 = " + emp1.equals(emp2));
	}

}
