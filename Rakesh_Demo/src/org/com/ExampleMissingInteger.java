package org.com;

import java.util.Arrays;
import java.util.List;

public class ExampleMissingInteger {
	
	public static void main(String args[]) {
		
		List<Integer> list = Arrays.asList(1,2,3,5,6);
		int n= list.size()+1;
		int totalSum = n*(n+1)/2;
		int newSum =0;
		System.out.println(n);
		
		for(Integer intValue: list) {
			newSum+= intValue;
		}
		
		int missing  = totalSum-newSum;
		System.out.print("missing value ="+missing);
		
	}

}
