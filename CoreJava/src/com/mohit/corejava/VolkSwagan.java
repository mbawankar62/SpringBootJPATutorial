package com.mohit.corejava;

public class VolkSwagan {
	
	public static void main(String args[]) {
		
		String input = "acabmnxyz";
		char str[] = input.toCharArray();//a == 
		for (int i = 1; i < str.length; i++) {
			
			if ((str[i] == str[i - 1] + 1) || (str[i] == str[i - 1] - 1)) {
				//System.out.print(str[i] == str[i - 1] + 1);
				System.out.print(str[i]);
			} else {
				System.out.print("\n" + str[i]);
			}
		}}
	}

//https://www.geeksforgeeks.org/print-consecutive-characters-together-line/
//c c 

// c == a98 || c==a97
// a == c || a == c 
//a