package com.mohit.corejava.nestedClassDemo;

public class OuterClass {

	private int data=30;
	
	 class Inner{  
	  void msg(){
		  System.out.println("data is "+data);
		  }  
	 }  
	 public static void main(String args[]){  
		 OuterClass obj=new OuterClass();  
		 OuterClass.Inner in=obj.new Inner();  
		 in.msg();  
	 }  
}
