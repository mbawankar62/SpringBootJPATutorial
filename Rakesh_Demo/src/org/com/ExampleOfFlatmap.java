package org.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleOfFlatmap {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Geek", "For", "Geeks");
		
		Stream<Object> a = list.stream().flatMap(str->Stream.of(str.charAt(2)));
		a.forEach(System.out::println);
		
		List<Integer> evenNo = Arrays.asList(2,4,6);
		List<Integer> oddNo = Arrays.asList(1,3,5);
		
		List<List<Integer>> listOfInt = Arrays.asList(evenNo, oddNo);
		
		List<Integer> fl = listOfInt.stream().flatMap(list3 -> list3.stream()).collect(Collectors.toList());
		
		System.out.println(fl);

	}

}
