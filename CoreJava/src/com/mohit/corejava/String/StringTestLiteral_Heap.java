package com.mohit.corejava.String;

public class StringTestLiteral_Heap {

	public static void main(String[] args) {

		String s1="Sachin";
		s1.concat("Tendulkar");
		System.out.println(s1);//Sachin
		s1=s1.concat("Tendulkar");
		System.out.println(s1);//SachinTendulkar
		
		String s2="Mohit";
		String s3="Mohit";
		String s4=s3;//s4 ref variable referes to s3
		//s4.concat("Bawankar"); //Mohit
		//s4=s4.concat("Bawankar"); //Mohit Bawankar
		s3=s3.concat("Bawankar"); //Mohit Bawankar
		
		System.out.println("s2::"+s2);
		System.out.println("s3::"+s3);
		System.out.println("s4::"+s4);
		System.out.println(s3.equals(s4));
		
		
		
		 String str="Knowledge";
	      String s=str;
	      str=str.concat(" Base");
	      System.out.println(str);
	}

}
