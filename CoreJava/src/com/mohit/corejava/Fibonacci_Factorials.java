package com.mohit.corejava;

public class Fibonacci_Factorials {

	public static void main(String[] args) {

		// 4 = 4*3*2*1;
		// a= 0 ,b = 1 , c= a+b;

		int n = 4;
		int fact = 1;

		// 0 1 1 2 3
		int a = 0;
		int b = 1;
		int c;

		for (int i = 1; i <= n; i++) {
			fact = fact * i; // 1*1

		}

		System.out.println("Factorial of " + n + "is:" + fact);

		for (int j = 2; j < n; j++) {

			c = a + b;
			a = b;
			b = c;
		}

	}

}
