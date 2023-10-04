package org.com;

public class ReverseWords {

	public static void main(String[] args) {

		String s ="i love teaching";
		String rev = " ";
		String[] sArr = s.split(" ");
		
		for(int i=sArr.length-1; i>=0; i--) {
			rev +=sArr[i]+ " ";
		}
		System.out.println(rev);
	}

}
