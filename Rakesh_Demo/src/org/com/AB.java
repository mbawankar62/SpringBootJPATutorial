package org.com;

//for abstract method if method are same in 2 interface A, B then no ambiguity.
//for default method if method are same in 2 interface A, B then no ambiguity will come in that case will use interface.super keyword.
public class AB implements A, B {

	
	public void show() {
		System.out.println("display");
		
	}
	
	@Override
	public void defaultMethod() {
		A.super.defaultMethod();//to resolve ambiguity
		B.super.defaultMethod();
	}

	public static void main(String[] args) {
		
		AB ab = new AB() ;
			ab.show();
			ab.defaultMethod();
		
	}

	
	

	

}
