package com.mohit.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.Optional;
import java.util.stream.Collectors;

class Student {
	
	private String name;
	private int marks;
	
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	
	
}

public class Student_name_marks {
	public static void main(String[] args) {
		
		Student s1 = new Student("Mohit", 70);
		Student s2 = new Student("Anant", 80);
		Student s3 = new Student("Rahul", 100);

		Map<Integer, Student> map = new HashMap<>();
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);

		
		
		List<Student> list = Arrays.asList(s1,s2,s3);
		System.out.println("Student list::"+list);
		Student list2 =list.stream().collect(Collectors.minBy(Comparator.comparing(Student::getMarks))).get();
		System.out.println("Student of Minimum Marks::"+list2);
		System.out.println("-------------------------------------------------------");
		
		System.out.println(map);
		
		for(Map.Entry<Integer,Student> entry:map.entrySet()) {
			System.out.println("Student_Id::"+entry.getKey()+"  Student_Name::"+entry.getValue());
		}
		
		System.out.println("-------------------------------------------------------");
		
		Optional<Entry<Integer, Student>> min = map.entrySet().stream()
	                				.min(Comparator.comparing(entry -> entry.getValue().getMarks()));
	      
		System.out.println ("min marks with optional::-->"+min.get ());
		
	    System.out.println("-------------------------------------------------------");
		
	    List<Integer> listInt = Arrays.asList(1,2,3,4,5,6,2,4,3,1,1,1);
	    Map<Integer, Long> collectWithCount = listInt.stream().collect((Collectors.groupingBy(Function.identity(),Collectors.counting())));
	    System.out.println(collectWithCount);
	    LongSummaryStatistics longSummaryStatistics = collectWithCount.entrySet().stream().collect(Collectors.summarizingLong(e->e.getValue()));
	    System.out.println(longSummaryStatistics);
	    System.out.println(longSummaryStatistics.getSum());
	
	}
}