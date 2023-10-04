package com.mohit.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main (String args[]) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(12);
		list.add(07);
		list.add(15);
		list.add(50);
		list.add(03);
		list.add(50);
		
		System.out.println("Original List:"+list);
		for(Integer emp: list)
		{
			System.out.println("List after iteration : " +emp);
		}
		
		/*---------------------- Filter--------------------- */
		
		System.out.println("---------------------- Filter---------------------");
		List<Integer> streamResult =list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("Original List after stream Filter:"+streamResult);
		Set<Integer> streamResult11 =list.stream().filter(i->i%2==0).collect(Collectors.toSet());
		System.out.println("Original List after stream Filter set:"+streamResult11);
		long streamResult1 =list.stream().filter(i->i%2==0).count();
		System.out.println("Original List after stream().filter().count()=:"+streamResult1);
		
		 List<String> list33 = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
		 List<String> resultList33=list33.stream().filter(s->s.startsWith("H")).collect(Collectors.toList());
		 System.out.println("List Start with H:"+resultList33);
		 
		/*---------------------- forEach--------------------- */
		System.out.println("---------------------- forEach---------------------");
		System.out.println("Original List after forEach:");
		list.stream().forEach(System.out::println);
		
		Consumer<Integer> c=i-> {System.out.println("the square of "+i+" is :"+(i*i));
								};
		list.stream().forEach(c);	
								
		/*---------------------- map--------------------- */
		System.out.println("---------------------- map---------------------");	
		
		List<Integer> maplist = list.stream().map(i->i+5).collect(Collectors.toList());
		System.out.println("Original List after stream map i+5=:"+maplist);
		
		/*---------------------- sorted--------------------- */
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("sorted list:"+sortedList);
		
		List<Integer> sortedList1 = list.stream().map(i->i*i).sorted().collect(Collectors.toList());
		System.out.println("sorted list with map i*i:"+sortedList1);
		
		List<Integer> sortedList2 = list.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList());
		
		System.out.println("sorted list compareTo and reverse order using sorted :"+sortedList2);
		
		/*---------------------- min and max--------------------- */
		
		Integer min = list.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Min value: " +min);
		
		Integer max = list.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Max value: " +max);
		
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int maxValue =  myList.stream().max(Integer::compare) .get();
        System.out.println(maxValue);     
		/*---------------------- toArray--------------------- */
		
		//constructor reference
		//(Integer[]::new); -->array of type integer
		//Integer[] i = new Integer[]
		Integer[] i =list.stream().toArray(Integer[]::new);
		System.out.println(" list ---> toArray  : "+Arrays.toString(i));
		
		for(Integer i1 : i) {
		System.out.println(" list to toArray : " +i1);
		}
		
		//or
		System.out.println(" list to toArray by stream forEach : ");
		Stream.of(i).forEach(System.out::println);
		
		
		//Creating Stream From Collections
		System.out.println("Collection ---> Stream");
		Collection<String> collection = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
        Stream<String> stream2 = collection.stream();
        stream2.forEach(System.out::println);
        /*
        List<String> list3 = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
        Stream<String> stream3 = list3.stream();
        stream3.forEach(System.out::println);

        Set<String> set = new HashSet<>(list3);
        Stream<String> stream4 = set.stream();
        stream4.forEach(System.out::println);
        */
        //remove duplicate
        ArrayList<Integer> arlist = new ArrayList<>(Arrays.asList(1,1,2,3,2,3,3,4,4,4));
        List<Integer> Uniquesarlist =arlist.stream().distinct().collect(Collectors.toList());
        System.out.println(" list of arraylist:"+arlist);
        System.out.println(" after removing duplicate from  list using Distinct() :"+Uniquesarlist);
        System.out.println(" after removing duplicate from  list using toSet() :"+arlist.stream().collect(Collectors.toSet()));
        
        
        List<Integer> sortedlist = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("sortedlist:"+sortedlist);
        
        /*-----------------------------------------------------------------------------------------------*/
        
        Map<String,Integer> map = new HashMap<>();
        map.put("anil",1000);
        map.put("ankit",1200);
        map.put("bhavna",1300);
        map.put("james",1400);
        map.put("micael",1500);
        map.put("tom",1600);
        //map.put("mohit",1600);
        map.put("daniel",1700);
        
        Map.Entry<String,Integer> finalResult = map.entrySet()
				                .stream()
				                .sorted(Comparator.comparing(entry -> -entry.getValue())) // minus make it to do in desc order
				                .toList()
				                .get(1); // index start from
        
        System.out.println("2nd highest salary:"+finalResult);
        
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);
        //map2.put("daniel",1400);
        /* Now get(1) will return any random value with either tom or daniel.
		  The trick to solve this issue is to invert the map like below */
        /*Now we have inverted the map and result will be like below but in random order.*/
        
        Map<Integer,List<String>> interimResult = 
        map2.entrySet().stream()
        .collect(Collectors.groupingBy(entry -> entry.getValue(),
        		                       Collectors.mapping(entry -> entry.getKey(),Collectors.toList())));
        System.out.println("employess list with salary:"+interimResult);
        
        //final way 
        //comapre output with above you will notice diff
        Map.Entry<Integer,List<String>> finalResult2 = 
        		map2.entrySet().stream()
                .collect(Collectors.groupingBy(entry ->entry.getValue(),
                         						Collectors.mapping(entry -> entry.getKey(),Collectors.toList())
                          ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(t -> -t.getKey()))
                .toList()
                .get(1);
       System.out.println("2nd highest salary final result:"+finalResult2);
       
      // Optional<Integer> findFirst = list.stream().map(e->e.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst();
	  //System.out.println("Employees 2nd Highest salary : " +findFirst);
       //employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
      
       
       // Using peek without any terminal operation does nothing
       List<Integer> peeklist = Arrays.asList(0, 2, 4, 6, 8, 10);
       
       System.out.println("peek example");
       //peeklist.stream().peek(System.out::println);
       Long newList = peeklist.stream().peek(System.out::println).count();
       List<Integer> newList2 = list.stream().peek(System.out::println).collect(Collectors.toList());
    		      							
       System.out.println(newList);
       //System.out.println(newList2);
       
       List<Integer> numbers = Arrays.asList(9,56,89,1, 2, 3, 4, 5);
       numbers.stream().sorted().collect(Collectors.toList()).forEach(S->System.out.println("--------sorted data::"+S));
       numbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).forEach(S->System.out.println("--------sorted data"+S));;
       //Integer sum = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
      // Integer sumOfQuantities = products.stream().collect(Collectors.summingInt(Product::getQuantity));
       //Optional<Integer> sum = numbers.stream().collect(Collectors.maxBy(Integer::compareTo));
       Optional<Integer> sum =numbers.stream().collect(Collectors.maxBy(Comparator.reverseOrder()));
       System.out.println("Sum: " + sum);
       
       /******************************Reduce Demo**************************************/
       
       int[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       int sum1 = 0;
       for (int i1 : numbers1) {
           sum1 += i1;
       }
       System.out.println("sum with java8 : " + sum1); // 55

       Optional<Integer> reduce_sum = list.stream().reduce((a,b)->a+b);
       System.out.println("reduce_sum: " + reduce_sum);
       Optional<Integer> reduce_sum_with_sumMethod = list.stream().reduce(Integer::sum);
       System.out.println("reduce_sum: " + reduce_sum_with_sumMethod);
       Optional<Integer> reduce_min = list.stream().reduce(Integer::min);
       System.out.println("reduce_min: " + reduce_min);
       Optional<Integer> reduceValueComapare = list.stream().reduce((a,b)->a>b?a:b);
       System.out.println("reduceValueComapare: " + reduceValueComapare);
       
       List<String> words = Arrays.asList("GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks");
       Optional<String> longestString = words.stream().reduce((word1, word2)-> word1.length() > word2.length()? word1 : word2);
       // Displaying the longest String
       longestString.ifPresent(System.out::println);
       
       String[] array = { "Geeks", "for", "Geeks" };
       Optional<String> String_combine = Arrays.stream(array).reduce((str1, str2) -> str1 + "-" + str2);
       // Displaying the combined String      
       if (String_combine.isPresent()) 
    	   System.out.println(String_combine.get());

       // Creating list of integers
       List<Integer> array_1 = Arrays.asList(-2, 0, 4, 6, 8);
 
       // Finding sum of all elements
       int sum_array = array_1.stream().reduce(0,(element1, element2) -> element1 + element2);
 
       // Displaying sum of all elements
       System.out.println("The sum of all elements is " + sum_array);
       
  
       int product = IntStream.range(2, 8).reduce((num1, num2) -> num1 * num2) .orElse(-1);
       // Displaying the product
       System.out.println("The product is : " + product);
       

       String[] strings = {"a", "b", "c", "d", "e"};

       // |a|b|c|d|e , the initial | join is not what we want
       String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);

       // a|b|c|d|e, filter the initial "" empty string
       String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
           if (!"".equals(a)) {
               return a + "|" + b;
           } else {
               return b;
           }
       });

       // a|b|c|d|e , better uses the Java 8 String.join :)
       String join = String.join("|", strings);
     
	}
}
