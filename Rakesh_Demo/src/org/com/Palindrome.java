package org.com;

public class Palindrome {
	
	public static void main(String args[]) {
		
		String original = "Radar";
		String reverse ="";
		
		for(int i = original.length()-1 ; i >= 0; i--) {
			
			reverse = reverse+ original.charAt(i);
		}
		
		if(reverse.equals(original)) {
			System.out.print(original+" is Palindrom");
		}
		
		else {
			System.out.print(original+" is not Palindrom");
		}
		
		//for integer
		
		int num = 353; 
		int originalNum = num;
		int remainder = 0;
		int reverseNumber = 0;
		
		while(num!=0) {
			remainder = num%10;
			reverseNumber = remainder*10+remainder;
			num/=10;
		}
		
		if(num== reverseNumber) {
			
			System.out.println(originalNum+"is palindrome");
		}
		else {
			
			System.out.println(originalNum+"is not palindrome");
		}
	}

	
}
