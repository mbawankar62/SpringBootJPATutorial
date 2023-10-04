package com.mohit.corejava.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapKeyIncrementBy10 {

	public static void main(String args[]) {
		
		 // Creating an empty HashMap
        Map<Integer, String> map = new HashMap<>();
  
        // Inserting pairs in above Map
        // using put() method
       map.put(1, "mohit");
       map.put(2, "rohit");
       map.put(3, "tohit");
       map.put(4, "gohit");
       map.put(5, "pohit");
        
      List<Integer> keylist=  new ArrayList<Integer>(map.keySet());
      System.out.println(keylist);
    
      for(int i=0 ; i<keylist.size();i++) {
    	  map.put(keylist.get(i)+10 ,map.get(keylist.get(i)));
    	  map.remove(keylist.get(i));
      }
      System.out.println(map);
	}
}
