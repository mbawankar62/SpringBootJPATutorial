package com.mohit.corejava.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OptionalTest {
	/**
	 * If the element is not null, then both Optional.of and Optional.ofNullable behavior is same.
	 *  But in case of null, Optional.of throws NullPointerException, 
	 *  whereas Optional.ofNullable return empty Optional.
	 * @param args
	 */
	 public static void main(String args[]) {
		 
	//List to map
	List<String> list = new ArrayList<String>(Arrays.asList("AA1","2","3","4","5"));
	Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Function.identity(),String::length));
	System.out.println(collect);
		
	List<Student> studentList = new ArrayList<>();
	studentList.add(new Student(1,"Mohit"));
	studentList.add(new Student(2,"Rohit"));
	studentList.add(new Student(3,"Ananat"));
	studentList.add(new Student(4,"Hitesh"));
	
	Map<Integer, String> studentsMap = studentList.stream().collect(Collectors.toMap(Student :: getId, Student :: getName));
	System.out.println("List-->Map::"+studentsMap);   
			
		 
	        String str = "Hello World";

	        Optional<String> optionalOf = Optional.of(str);
	        Optional<String> optionalNullable = Optional.ofNullable(str);

	        System.out.println("For non null value");
	        System.out.println("\toptionalOf1 : " + optionalOf.get());
	        System.out.println("\toptionalNullable : " + optionalNullable.get());

	        str = null;

	        System.out.println("\nFor null value");
	        try {
	            optionalOf = Optional.of(str);
	        } catch (NullPointerException e) {
	            System.out.println("\tNullPointerException thrown for 'Optional.of' method");
	        }

	        optionalNullable = Optional.ofNullable(str);
	        System.out.println("\toptionalNullable : "+optionalNullable);

	        try {
	            System.out.println("optionalNullable : " + optionalNullable.get());
	        } catch (NoSuchElementException e) {
	            System.out.println("\tNoSuchElementException thrown for 'optionalNullable.get()' method");
	        }
	        
	        System.out.println();
	        /**************************************************************************/
	        //String[] words = new String[10];
	        //Optional<String> checkNull = Optional.ofNullable(words[5]);
	        
	        String string = "Mohit Bawankar";
	        //Optional<String> checkNull = Optional.ofNullable(words[5]);
	        Optional<String> checkNull = Optional.ofNullable(string);
	           
	        if (checkNull.isPresent()) {
	            String word = string.toLowerCase();
	            System.out.println("Optional.ofNullable(string)::"+word);
	        }
	        else
	            System.out.println("word is null");
	        
	        /**************************************************************************/

	    }
}

class Student {
	
	private String name;
	private int id;
	
	public Student(int id ,String name) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}

