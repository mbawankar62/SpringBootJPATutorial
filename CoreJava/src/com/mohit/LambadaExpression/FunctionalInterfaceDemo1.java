package com.mohit.LambadaExpression;

public class FunctionalInterfaceDemo1  {

	public static void main (String argd[]) {
		
		//IntefaceA addnumber = (a,b)->System.out.println(a+b);
		//addnumber.add(10, 20);
		
		//Inteface1 addnumber = (a,b)->{ return a+b; };
		Inteface1 addnumber = (a,b)-> a+b;
		System.out.println(addnumber.add(10, 20));
		
	}
}
