package com.mohit.corejava;


class Parent {

	void Print() {
		System.out.println("parent class");
	}
	
	public static void testMethod() {
		System.out.println("parent class static method");
	}
}

class subclass1 extends Parent {
	
	void Print() {
		System.out.println("subclass1");
	}
	
	void Print2() {
		System.out.println("subclass1 Print2");
	}
	public static void testMethod() {
		System.out.println("subclass1 class static method");
	}
}

class subclass2 extends Parent {
	void Print() {
		System.out.println("subclass2");
	}
	
	public static void testMethod() {
		System.out.println("subclass2 class static method");
	}
}

public class PolyMorphism {

	public static void main(String[] args) {
		 
        // Creating object of class 1
        Parent a;
        // Now we will be calling print methods
        // inside main() method
        Parent.testMethod();
        
        a = new subclass1();
        a.Print();
        a.testMethod();
        
 
        a = new subclass2();
        a.Print();
        
        Parent parent = new subclass1();
        //parent.print2(); // compile time
        

	}

}
