package org.com;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatedCharUSingHashMAp {

	public static void getCount(String s) {
		
		HashMap<Character, Integer> hm = new HashMap<>();
		char[] charArray = s.toCharArray();
		for(char c: charArray) {
			
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c)+1);
			}
			else {
				hm.put(c, 1);
			}
		}
		for(Map.Entry entry: hm.entrySet()) {
			System.out.println("char-"+entry.getKey()+":"+entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		String input = "abcdaab";
		getCount(input);
	}
}
