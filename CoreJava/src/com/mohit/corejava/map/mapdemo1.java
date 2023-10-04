package com.mohit.corejava.map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class mapdemo1 {
	// Main driver method
		public static void main(String args[])
		{
			// Creating an empty HashMap
			Map<String, Integer> hm = new HashMap<String, Integer>();

			// Inserting pairs in above Map
			// using put() method
			hm.put("a", 100);
			hm.put("b", 200);
			hm.put("c", 300);
			hm.put("d",400);
			
			// Traversing through Map using for-each loop
			for (Map.Entry<String, Integer> me :hm.entrySet())
			{   // Printing keys
				
				System.out.print(me.getKey() + ":");
				if(me.getKey()== "d")
					hm.remove("d");
				System.out.println(me.getValue());
			}
			
			//Iteration using lambda expression
			//hm.forEach((k,v)-> System.out.println(k+ " : " +v));
			hm.forEach((k,v)->System.out.println("key:"+k+"   value:"+v));
			
			// Traversing through Map  using keySet() and values() methods
			
			for(String  str : hm.keySet())
				System.out.println(" Keys: " +str);
			for(Integer  i : hm.values())
				System.out.println(" Values: " +i);
			
			// using iterators
	        Iterator<Map.Entry<String, Integer>> itr = hm.entrySet().iterator();
	          
	        while(itr.hasNext())
	        {
	             Map.Entry<String, Integer> entry = itr.next();
	             //hm.put("c", 0000);
	             
	             System.out.println("Key = " + entry.getKey() +  ", Value = " + entry.getValue());
	                                
	        }
	    }
		
}

