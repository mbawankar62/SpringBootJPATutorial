package com.mohit.corejava.Tiaa_overloading_Overriding;

public interface Interface2 {

	public void method1(String str);
	
	public void method2();
	
	default void show(String str){
		System.out.println("I2 show::"+str);
	}
	
	default void show2(String str){
		System.out.println("I2 show::"+str);
	}
	
	static void showStatic(String str){
		System.out.println("I2 showStatic::"+str);
	}
	
	static void showStatic2(String str){
		System.out.println("I2 showStatic::"+str);
	}
}
