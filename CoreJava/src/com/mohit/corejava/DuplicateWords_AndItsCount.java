package com.mohit.corejava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class DuplicateWords_AndItsCount {
	
    public static void main(String args[]) {
    	
      // Given Input String containing duplicate words
      String input = "Geeksforgeeks";
      
      Set<String> uniqueWords2 = new HashSet<>(Arrays.asList(input));
      System.out.println("unique word using set:"+uniqueWords2);
      
      // Converting given Input String to lowerCase
      //input = input.toLowerCase();
      
      /* Split the given Input String into words using built-in split() method */
     
      String[] strArray = input.split("");	
      
      System.out.println("strArray:" + Arrays.toString(strArray));
      
	 // Declare List of String that will contain repeated words	 
	 List<String> repeatedWords = new ArrayList<>();

	// Declare HashSet of String that will contain unique words
		Set<String> uniqueWords = new HashSet<>();

		for (String str : strArray) {
			if (!uniqueWords.add(str))
				repeatedWords.add(str);
		}
		System.out.println("uniqueWords:" + uniqueWords);
		System.out.println("repeated:" + repeatedWords);
		
/*

Find and count duplicates in an Arrays :
Using Stream.distinct() method
Using Stream.filter() and Collections.frequency() methods
Using Stream.filter() and Set.add() methods
Using Collectors.toMap() method and Method Reference Math::addExact for summation of duplicates
Using Collectors.groupingBy() and Collectors.counting() methods
Using Map.getOrDefault() and Collection.forEach() methods
Using Map.merge() and Collection.forEach() methods and lambda Expression for counting duplicates

*/
		//String input_1= "12456733";
		//String[] companies = input_1.split("");
		//String[] companies = {"Meta", "Apple","Amazon", "Netflix","Meta","Google","Apple"};
		String[] companies = new String[]{"Meta", "Apple","Amazon", "Netflix","Meta","Google","Apple"};
		// 1.1 print String[] array to console
        System.out.println("1. Original String[] Array with duplicates : \n");
        Arrays.stream(companies).forEach(System.out::println);
        
        // 2. get unique elements after removing duplicates
        String[] distinctCompanies = Arrays.stream(companies).distinct().toArray(String[]::new);
        
        // 2.1 print unique elements
        System.out.println("\n2. Unique elements in String[] array : \n");
        Arrays.stream(distinctCompanies).forEach(System.out::println);
        
        // 2.2 Unique element count
        System.out.println("\nNumber of Unique elements = " + distinctCompanies.length);
 
        // 3. create List<String> with original String[] array  elements
        List<String> originalCompanyList = new ArrayList<String>(Arrays.asList(companies));
 
        // 3. get duplicate elements
        for (String distinctCompany : distinctCompanies) {
            originalCompanyList.remove(distinctCompany);
        }
 
        // 3.1 print duplicate elements
        System.out.println("\n3. Duplicate elements in String[] array : \n");
        originalCompanyList.forEach(System.out::println);
 
 
        // 3.2 Duplicate element count
        System.out.println("\nNumber of Duplicate elements = "+ originalCompanyList.size());
        
       /*************************************************************************************/ 
        // 2. get unique elements after removing duplicates
        
        Set<String> distinctCompanies_list = Arrays.stream(companies).collect(Collectors.toSet());
 
        // 2.2 print unique elements
        System.out.println("\n2. Unique elements in String[] array : \n");
        distinctCompanies_list.forEach(System.out::println);
 
        // 2.3 Unique element count
        System.out.println("\nNumber of Unique elements = " + distinctCompanies_list.size());
 
        // 3. get duplicate elements
        Set<String> duplicateCompanies = Arrays.stream(companies)
                						.filter(company -> Collections.frequency(Arrays.asList(companies), company) > 1)
                						.collect(Collectors.toSet());
 
        // 3.1 print duplicate elements
        System.out.println("\n3. Duplicate elements in String[] array using set : \n");
        duplicateCompanies.forEach(System.out::println);
        
        
        List<String> duplicateCompanies_List = Arrays.stream(companies)
				.filter(company -> Collections.frequency(Arrays.asList(companies), company) > 1)
				.collect(Collectors.toList());
        System.out.println("\n3. Duplicate elements in String[] array using list : \n");
        duplicateCompanies_List.forEach(System.out::println);
 
        // 3.2 Duplicate element count
        System.out.println("\nNumber of Duplicate elements = "+ duplicateCompanies.size());
        
        /*************************************************************************************/ 
                
        // 2. create Set object to store unique elements
        Set<String> uniqueCompanies = new HashSet<>();
 
 
        // 3. get duplicate elements
        Set<String> duplicateCompanies2 = Arrays.stream(companies) .filter(company -> !uniqueCompanies.add(company))
                							   .collect(Collectors.toSet());
        
        // 2.1 print unique elements
        System.out.println("\n2. Unique elements in String[] array : \n");
        uniqueCompanies.forEach(System.out::println);
        
        /*************************************************************************************/ 
        String input_1= "12456733";
      	String[] companies1 = input_1.split("");
        System.out.println();
        // 4. get duplicate count using Map
        
   // 3. get duplicate elements
   Set<String> duplicateCompanies1 = Arrays.stream(companies1)
                				     .filter(company -> Collections.frequency(Arrays.asList(companies1), company) > 1)
                					 .collect(Collectors.toSet());
   System.out.println("duplicateCompanies1duplicateCompanies1duplicateCompanies1::--->"+duplicateCompanies1);
        
        // How to find only duplicate elements with its count from the String ArrayList in Java8?
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        String input123="llkklll";
        List<String> name12345=Arrays.asList(input123.split(""));
        Map<String,Long> namesCount = name12345.stream() .filter(x->Collections.frequency(name12345, x)>1)
        									.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                         
        System.out.println("namesCount::--->"+namesCount);
        
        Map<String, Long> duplicateCount = Arrays.stream(companies)
                						   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 
        System.out.println("Output in Map::"+duplicateCount);
        // 4.1 print Map for duplicate count
        System.out.println("\n4. Map Key as Company and Value as its duplicate count : \n");
        duplicateCount.forEach((key, value) -> System.out.println("Key : " + key + "\t Count : " + value));
        
        for(Map.Entry<String,Long> entry :duplicateCount.entrySet()) {
        	
        	if(entry.getValue() >= 2) {
        		//System.out.println("Key " + entry.getKey() +", Value = " + entry.getValue());
        		System.out.println(entry.getKey()+":"+ entry.getValue());       
        	}
        	
        }
        
        Stream<String> s = Stream.of("1", "2", "3", "4"); 
        long ans = s.collect(Collectors.counting());
        System.out.println(ans);
        /*************************************************************************************/ 

        List<String> list = new ArrayList<String>();
    	list.add("a");
    	list.add("b");
    	list.add("c");
    	list.add("c");
    	list.add("d");
    	list.add("b");
    	list.add("c");
    	list.add("a");
    	list.add("a");
    	list.add("a");
    	
    	//find first duplicate value
    	Optional<String> findFirst = list.stream().filter(a->Collections.frequency(list, a)>1).findFirst();
    				// .forEach(sout->System.out.println("find first duplicate value :"+sout));
    	System.out.println("find first duplicate value : " + findFirst);
    	
    	System.out.println("\nExample 1 - Count 'a' with frequency");
    	System.out.println("a : " + Collections.frequency(list, "a"));

    	System.out.println("\nExample 2 - Count all with frequency");
    	Set<String> uniqueSet = new HashSet<String>(list);
    	for (String temp : uniqueSet) {
    		//System.out.println(temp + ": " + Collections.frequency(list, temp));
    		if(Collections.frequency(list, temp)>=2)
    			System.out.println(temp + ": " + Collections.frequency(list, temp));
    	}

    	System.out.println("\nExample 3 - Count all with Map");
    	Map<String, Integer> map = new HashMap<String, Integer>();

    	for (String temp : list) {
    		Integer count = map.get(temp);
    		map.put(temp, (count == null) ? 1 : count + 1);
    	}
    	printMap(map);
    				
    	System.out.println("\nSorted Map");
    	Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
    	printMap(treeMap);
    		
      }
    	
      public static void printMap(Map<String, Integer> map){

    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		System.out.println("Key : " + entry.getKey() + " Value : "
    			+ entry.getValue());
    	}
    		
       /*********************************************************************************************/
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
              
        /*********************************************************************************************/
        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList1.stream().findFirst().ifPresent(System.out::println);
              
        int max =  myList1.stream().max(Integer::compare) .get();
        System.out.println(max);      
               
 
        /*********************************************************************************************/
        //Write a program to print the count of each character in a String?   
        String s = "string data to count each character";       
        Map<String, Long> mapResult = Arrays.stream(s.split("")).map(String::toLowerCase)
        		 				.collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
           
        System.out.println(mapResult);
        
        /*********************************************************************************************/        
        List<Integer> duplicates = IntStream.of( 1, 2, 3, 2, 1, 2, 3, 4, 2, 2, 2 )
        		   .boxed()
        		   .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
        		   .entrySet()
        		   .stream()
        		   .filter( p -> p.getValue() > 1 )
        		   .map( Map.Entry::getKey )
        		   .collect( Collectors.toList() );
        System.out.println(duplicates);
        /*********************************************************************************************/        
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
        		.collect(Collectors.toMap(Function.identity(), x -> String.valueOf(x)));
        System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}
        
        //Map<String,Long> namesCount = name12345.stream() .filter(x->Collections.frequency(name12345, x)>1)
				//.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                  
	}
}