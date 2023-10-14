package com.mohit.corejava;

/**
Return “fizz”, “buzz” or “fizzbuzz”.
For a given natural number greater than zero return:
“fizz” if the number is divisible by 3
“buzz” if the number is divisile by 5
“fizzbuzz” if the number is divisible by 3 and 5
Return the same input if no other requirement is fulfilled
*/
public class FizzBuzz {

	public static void main(String[] args) {
		
		int num = 4 ;
		
		if(num % 3 ==0 )
			System.out.println("fizz");
		else
			if (num % 5 == 0 )
				System.out.println("buzz");
			else 
				if(num % 5 == 0 && num % 3 ==0 )
					System.out.println("fizzbuzz");
				else
					System.out.println("original value: " +num);

	}

}
