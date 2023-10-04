package com.mohit.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestRepeatedValueFromarryas {
	

	public static void main(String[] args) {
		Integer arr[] = { 23, 29, 31, 37, 39 };

		//String arrToStr = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
		String arrToStr = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
		System.out.println(arrToStr);
		
		List<String> list = Arrays.asList(arrToStr.split(""));
		// filter(s->Collections.frequency(list, s)>1)
		System.out.println(list);
		Map<String, Long> map1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map1);
		
		/*
		Map.Entry<String, Long> maxEntry = null;
		for (Map.Entry<String, Long> entry : list2.entrySet()) {

			if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		System.out.println(maxEntry);*/
		
		Optional<Entry<String, Long>> map2 =map1.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		System.out.println(map2.get().getKey());       
		//Optional<Entry<Integer, Student>> min = map.entrySet().stream()
				//.min(Comparator.comparing(entry -> entry.getValue().getMarks()));
		//list.stream().collect(Collectors.minBy(Comparator.comparing(Student::getMarks())).get();
		//Map<int,int>list2=list1.entrySet().stream().max(Comparator.comparing(Map.Entry::getValues)));
	}



}
