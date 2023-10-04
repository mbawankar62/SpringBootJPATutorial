package com.mohit.LambadaExpression;

public class Demo2 {

	public static void main(String[] args) {

		// Interface2 i2 = () -> System.out.println("Hello Mohit");
		// i2.method1();

		Interface2 i2 = (s) -> s.length();
		System.out.println(i2.getLength("Mohit"));

	}

}
