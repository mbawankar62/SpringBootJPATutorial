package com.mohit.corejava.Tiaa_overloading_Overriding;

class OverloadindExample{
	
	public void display(Object obj) {
		System.out.println("inside Object type");
	}
	
	public void display(Integer int1) {
		System.out.println("inside Integer type");
	}
	
	public void display(int intObj) {
		System.out.println("inside int type");
	}
	
	public void display(String str) {
		System.out.println("inside String type");
	}
	
}
public class OverloadingTest {

	public static void main(String[] args) {
		
		OverloadindExample test = new OverloadindExample();
		//test.display(null); //ambiguous
		test.display("null");
		test.display(1);

	}

}
