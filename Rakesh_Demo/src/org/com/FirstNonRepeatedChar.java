package org.com;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

	public static Character findFirstNonRepeatableChar(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        return map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
} 
    

    public static void main(String[] args)
    {
        String s = "hello";
        char ch = findFirstNonRepeatableChar(s);
        System.out.println( ch);
        
        char c1 = get(s);
        System.out.println(c1);
        
    }


	private static Character get(String s) {
		String s2 ="hellojava";
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for(Character c : s2.toCharArray()) {
        	hm.put(c, hm.containsKey(c)? hm.get(c)+1: 1);
        }
		return hm.entrySet().stream().filter(x->x.getValue()==1).findFirst().get().getKey();
        
		
	}
    
}
