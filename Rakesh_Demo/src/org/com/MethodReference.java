package org.com;

public class MethodReference {

	
	//static method
	public static void saysomething() {
		System.out.println("Hello static method");
	}
	
	//non static method
	public void saySomething() {
		System.out.println("Non static method");
	}
	
	public static void main(String[] args) {
		
		//static call
		Sayable obj1 = MethodReference::saysomething;
		obj1.say();
		
		//non static call
		MethodReference obj = new MethodReference();
		Sayable obj2 = obj::saySomething;
		obj2.say();
		
	}

}
