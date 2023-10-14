package com.mohit.corejava.Tiaa_overloading_Overriding;

public class MyClassForInterfaceImpl implements Interface1, Interface2 {

	@Override
	public void method2() {
		
	}

	@Override
	public void method1(String str) {
		
	}

	//if u will not provide then it will give ambiguty 
	@Override
	public void show(String str){
		
		System.out.println("MyClassForInterfaceImpl show::"+str);
		Interface1.super.show("usingSuper I am calling Iterface1");
		
	}
	
	public static void main(String[] args) {
		
		MyClassForInterfaceImpl iter1 = new MyClassForInterfaceImpl();
		iter1.show("show");
		Interface1.showStatic("calling static method");
		Interface2.showStatic("calling static method");
	}

}
