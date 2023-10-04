package com.mohit.corejava.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {

		Map<String,Integer> map =new  HashMap<>();
		
		map.put("", 1);
		map.put(null, 2);
		map.put(null, null);
		map.put("Mohit", null);
		//map.put("Mohit", 6);
		
		map.put("Anant",7);
		map.put("anant", null);
		
		System.out.println("Output:"+map);
		
		System.out.println("Get"+map.get("Mohit"));
		
	}

}
