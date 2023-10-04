package com.mohit.corejava.String;

public class StringDemo {
	public static void main(String[] args) {
		String originalStr = "Hello Word";
		String reversedStr = "";

		for (int i = 0; i < originalStr.length(); i++) {
			
			System.out.println("originalStr.charAt(i) : " + originalStr.charAt(i) );
			reversedStr = originalStr.charAt(i) + reversedStr;
			System.out.println("reversedStr " + reversedStr );
		}
		System.out.println("Reversed string: " + reversedStr);
		
		String[] newString= originalStr.split(" ");
		String reversedStrNew = " ";
		//Hello  World
		//System.out.println(newString.length);//2
		for(int i =newString.length-1; i>=0 ;i--) {
			
			reversedStrNew+= newString[i]+" ";
		}
		System.out.println("Reversed string: " + reversedStrNew);
	}
}
