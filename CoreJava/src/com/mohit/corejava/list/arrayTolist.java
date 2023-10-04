package com.mohit.corejava.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayTolist {

	public static void main(String[] args) {

		//declare array 
		
		String[] str = {"mohit","Anant","Anisha","Arpit","Ankit"};
		
		System.out.println("printing an array:"+Arrays.toString(str));
		//create List
		List<String> list=new ArrayList<>();
		for(String s : str) {
			list.add(s);
		}
		System.out.println("Converted Array --->list :" +list);
	}

}
