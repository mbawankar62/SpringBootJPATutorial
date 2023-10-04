package org.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertListtoMap {

	public static void main(String[] args) {
		//============================================
		// 1st approach
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(30, "A");
		myMap.put(20, "C");
		myMap.put(10, "B");
		Map<Integer, String> sortedMap = 
			     myMap.entrySet()
			          .stream()
			          .sorted(Map.Entry.comparingByValue())
			          .collect(Collectors.toMap(Map.Entry::getKey,
			                                    Map.Entry::getValue, 
			                                    (a, b) -> a, //or throw an exception
			                                    LinkedHashMap::new));
		for(Map.Entry<Integer, String> entry: sortedMap.entrySet()) {
			
			System.out.println("key:"+entry.getKey()+", value:"+entry.getValue());
		}
		System.out.println("key value pair:"+sortedMap.toString());
		
		//2nd approach
		
		//Set<Entry<Integer, String>> se = myMap.entrySet();
		List<Entry<Integer, String>> l1 = new ArrayList<>(myMap.entrySet());
		Collections.sort(l1, (o1, o2)->o1.getKey().compareTo(o2.getKey()));
		 System.out.println("after sorting based on keyyyyyyyyyyy name :");
		l1.forEach(e ->System.out.println("key:"+e.getKey()+", value:"+e.getValue()));
		//sortedMap.forEach(System.out::println);
		//=============================================
		// SORT BASED ON EMP NAME OF GIVEN KEY AS A STRING AND VALUE AS AN EMPLOYEE
		  Map<String, Employee> staff = new HashMap<String, Employee>();
	      staff.put("3", new Employee(4, "tom", "HR"));
	      staff.put("4", new Employee(1, "jerry", "Manager"));
	      staff.put("1", new Employee(3, "mike", "DEV"));
	      staff.put("2", new Employee(2, "hussy", "QA"));
	      
	      System.out.println("original emp order:");
	      staff.forEach((k,v)-> System.out.println("key:"+k+"value:"+v));
	    		                
	      //Set<Entry<String, Employee>> s = staff.entrySet();
	      List<Entry<String, Employee>> list = new ArrayList<>(staff.entrySet());
	      Collections.sort(list, (o1, o2) -> o1.getValue().getName().compareTo(o2.getValue().getName()));
	      System.out.println("after sorting based on emp name :");
		   list.forEach(e ->System.out.println("key:"+e.getKey()+"value:"+e.getValue()));
			/*
			 * Collections.sort(list, Comparator<Entry<String, Employee>>(){
			 * 
			 * @Override public int compare(Entry<String, Employee> e1, Entry<String,
			 * Employee> e2) { return
			 * e1.getValue().getDesignation().compareTo(e2.getValue().getDesignation());
			 * 
			 * } });
			 */
		   
		sortBasedOnKeyAndValue();
		sortOnEmployeeDetails();
	}
	
	public static void sortBasedOnKeyAndValue() {
	 List<Employee> empList = new ArrayList<Employee>();
	  empList.add(new Employee(3,"Robert","Architect"));
	  empList.add(new Employee(2,"Martin","General Manager"));
	  empList.add(new Employee(1,"Jack","Manager")); 
	 
	  Map<Integer, String> map = empList.stream()
	                         .collect(Collectors.toMap(Employee::getId,Employee::getDesignation));
	  map.forEach((k,v) -> System.out.println("Key : "+ k + " , Value : "+ v )); 
	  
	  Map<String, Integer> map2 = empList.stream()
             .collect(Collectors.toMap(Employee::getDesignation,Employee::getId));
	  map2.forEach((k,v) -> System.out.println("Key : "+ k + " , Value : "+ v )); 
	}
	
	public static void sortOnEmployeeDetails(){
		
		Map<String, Employee> staff = new HashMap<String, Employee>();
	      staff.put("3", new Employee(4, "tom", "HR"));
	      staff.put("4", new Employee(1, "jerry", "Manager"));
	      staff.put("1", new Employee(3, "mike", "DEV"));
	      staff.put("2", new Employee(2, "hussy", "QA"));

	     // staff.remove("1");
	      // replace an entry
	      //staff.put("4", new Employee(1, "tom", "HR2"));
	      // look up a value
	     // System.out.println(staff.get("157-62-7935"));

	      // iterate through all entries
	      for (Map.Entry<String, Employee> entry : staff.entrySet())
	      {
	         String key = entry.getKey();
	         Employee value = entry.getValue();
	         System.out.println("key=" + key + ", value=" + value);
	      }
	      
	      
	}

}
