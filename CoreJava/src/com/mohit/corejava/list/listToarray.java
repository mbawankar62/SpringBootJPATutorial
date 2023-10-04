package com.mohit.corejava.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listToarray {

	public static void main(String[] args) {

		List<String> list=new ArrayList<>();
		list.add("mohit");
		list.add("Rohit");
		list.add("Tohit");
		list.add("Gohit");
		list.add("Dohit");
		
		System.out.println("Original List: "+list);
		
		//Conversion List--->Array
		
		String[] str = new String[list.size()];
		list.toArray(str);
		
		//u can use below line to optimize the code
		//String[] str1 = list.toArray(new String[list.size()]);
		
		System.out.println("List -->Array"+Arrays.toString(str));
	}

}
