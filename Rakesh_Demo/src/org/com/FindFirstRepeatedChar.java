package org.com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedChar {

	public static void main(String[] args) {
	
		List<Integer> listI = new ArrayList<>();
		listI.add(12);
		listI.add(10);
		listI.add(11);// 4th largest Integer
		listI.add(20);
		listI.add(13);
		
	Optional<Integer> iValue = listI.stream().sorted().skip(1).findFirst();
		System.out.println("4th largest Integer value:"+iValue.get());

		List<String> words = Arrays.asList("Welcome", "to", "the", "java", "world");
		
		Map<Character, Long> charFrequency = words.stream() //Stream<String>
		        .flatMap(a -> a.chars().mapToObj(c -> (char) c)) // Stream<Character>
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("key value pair:"+charFrequency.toString());
	}

}
