package com.mohit.corejava;

//Java program for the above approach
import java.util.*;

public class DuplicateCharUsing_Map {
	public static void main(String args[]) {
		String str = "geeksforgeeks";

		// Creating a HashMap containing char as a key and occurrences as a value
		Map<String, Integer> map = new HashMap<>();

		// Converting given string into a char array
		// char[] charArray = str.toCharArray();
		String[] arr = str.split("");

		// Checking each character of charArray
		for (String c : arr) 
		{
			if (map.containsKey(c))
			{
				// If character is present in map incrementing it's count by 1
				map.put(c, map.get(c) + 1);
			} 
			else
			{
				// If character is not present in map putting this character into map with
				// 1 as it's value.
				map.put(c, 1);
			}
		}
		// Traverse the HashMap, check if the count of the character
		// is greater than 1 then print the character and its frequency
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
	}

}
