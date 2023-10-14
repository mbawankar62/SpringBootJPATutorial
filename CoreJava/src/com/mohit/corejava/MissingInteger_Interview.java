package com.mohit.corejava;

import java.util.Arrays;
import java.util.List;

public class MissingInteger_Interview {
	
	public static void main(String args[]) {
		
		List<Integer> list = Arrays.asList(1,2,3,5,6);
		int n= list.size()+1;
		int totalSum = n*(n+1)/2;
		//System.out.println("totalSum::"+totalSum);
		int newSum =0;
		
		for(Integer intValue: list) {
			newSum+= intValue;
		}
		//System.out.println("newSum::"+newSum);
		
		int missing_Value  = totalSum - newSum;
		System.out.println("missing value ="+missing_Value);
		
		/*** Using Java1.8 ***/
		
		int arr[] = {1, 2, 4, 6, 3, 7, 8};
		int maxValue = Arrays.stream(arr).max().getAsInt();
		int expectedSum = maxValue*(maxValue+1)/2 ;
		int actualSum = Arrays.stream(arr).sum();
		int missingValue = expectedSum - actualSum ;
		System.out.println("missingValue using java8 ::"+missingValue);
		
		
	}

}
