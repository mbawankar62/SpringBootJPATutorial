package com.mohit.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondWordFromSentence {

	public static void main(String[] args) {
		
		String input = "Mohit is a good in core java";
		System.out.println(input.substring(input.lastIndexOf(" ")+1));
		
		String inputArray[] = input.split(" ");
		System.out.println("Output-inputArray[]::"+ Arrays.toString(inputArray));
		int n = inputArray.length;
		System.out.println("n:"+n);
		
		for(int i = 0; i<=n;i++) {
			
			if(i== n-2)
				System.out.println("2nd last element:"+inputArray[i]);
		}
		
		Integer a[]={1,2,5,6,3,2};
		List<Integer>list = new ArrayList<>(Arrays.asList(a));
		Collections.sort(list);
		System.out.println("Sortedlist:"+list);
		int element=list.get(list.size()-2);  
		System.out.println("2nd last element using Collection:"+element);
		

	}

}
