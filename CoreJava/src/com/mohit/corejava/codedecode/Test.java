package com.mohit.corejava.codedecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://www.youtube.com/watch?v=RynqGUbgw9k&list=PLyHJZXNdCXsfcMboYwGoL6wKAFPxljz5W&index=8&ab_channel=CodeDecode
public class Test {
/*
	public List<Long> list;
	public List<Student> listStu;
	public int listStuarr[];
	public int[] getListStuarr() {
		return listStuarr;
	}
	public void setListStuarr(int[] listStuarr) {
		this.listStuarr = listStuarr;
	}
	public List<Student> getListStu() {
		return listStu;
	}
	public void setListStu(List<Student> listStu) {
		this.listStu = listStu;
	}
	public List<Long> getList() {
		return list;
	}
	public void setList(List<Long> list) {
		this.list = list;
	}
	*/
	public static void main(String[] args) {

		int arr[]= {1,2,3,4,5,1};
		int arr2[]= {1,2,3,8,0,10};
		
		//1.find second smallest values Expected Output::2
		int output = Arrays.stream(arr).sorted().skip(1).findFirst()
						.orElseThrow(()->new IllegalArgumentException("no such element found"));
		System.out.println("Second smallest number:"+output);//1
		
		int output1 = Arrays.stream(arr).distinct().sorted().skip(1).findFirst()
				.orElseThrow(()->new IllegalArgumentException("no such element found"));
		System.out.println("Second smallest number:"+output1);//2
		
		//2.find common element from 2 arrays.
		//boxed() int --->Integer
		List<Integer> CommonElements = Arrays.stream(arr).filter(number->Arrays.stream(arr2).anyMatch(arr2num->arr2num==number))
						  .boxed().collect(Collectors.toList());
		System.out.println("CommonElements:"+CommonElements);
		
		//3.Reversing an array of integers in-place:
		//it means don't create new array just swap within array
		IntStream.range(0, arr.length/2).forEach(i->{
					int temp=arr[i];
					arr[i]= arr[arr.length-1];
					arr[arr.length-1] = temp;
		});
		System.out.println("Reversing an array of integers in-place:"+Arrays.toString(arr));
				
		//4.Finding the length of the longest string in an array:
		String input[]= {"Mohit","Bawankar","Kharbi","Naka","Engineer"};
		OptionalInt mapToInt = Arrays.stream(input).mapToInt(String::length).max();
		System.out.println("Max lenght string::"+mapToInt);
		
		//https://www.benchresources.net/java-8-find-longest-string-in-an-arrays-or-list-or-stream/
		String string = Arrays.stream(input).max(Comparator.comparingInt(String::length)).get();
		System.out.println("Max lenght of string name::"+string);
		
		//https://www.benchresources.net/java-8-find-all-shortest-strings-in-list-or-arrays-or-stream/
		Map<Integer, List<String>> String_with_itsCount = Arrays.stream(input).collect(Collectors.groupingBy(String::length));
		System.out.println("String_with_itsCount::"+String_with_itsCount);
		
		//now we can get min count string
		Optional<List<String>> map = String_with_itsCount.entrySet().stream().min(Map.Entry.comparingByKey()).map(Map.Entry::getValue);
		System.out.println("min size list-->"+map);
		
		List<Integer> listInt = Arrays.asList(1,2,3,4,5,6,2,4,3,1,1,1);
	    Map<Integer, Long> collectWithCount = listInt.stream().collect((Collectors.groupingBy(Function.identity(),Collectors.counting())));
	    System.out.println(collectWithCount);
	    LongSummaryStatistics longSummaryStatistics = collectWithCount.entrySet().stream().collect(Collectors.summarizingLong(e->e.getValue()));
	    System.out.println(longSummaryStatistics.getSum());
	    
	    List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
	    List<Integer> result = myList.stream().sorted().collect(Collectors.toList());
	    Stream<Integer> limit = result.stream().skip(1).limit(2);
	    System.out.println("2 and 3 rd lowest value::"+limit);
	}
	
	
	

}
