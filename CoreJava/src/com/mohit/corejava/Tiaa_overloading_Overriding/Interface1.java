package com.mohit.corejava.Tiaa_overloading_Overriding;

public interface Interface1 {

	public void method1(String str);
	
	default void show(String str){
		System.out.println("I1 show::"+str);
	}
	
	static void showStatic(String str){
		System.out.println("I1 showStatic::"+str);
	}
}
