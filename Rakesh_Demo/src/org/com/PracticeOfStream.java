package org.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeOfStream {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1, "A", 5000f));
		list.add(new Product(2, "B", 4000f));
		list.add(new Product(3, "B", 6000f));
		
		List<Integer> il = Arrays.asList(9,2,4,4,6,7);
		
		Integer[] numbers = new Integer[] { 2, 1, 3,7,3};
		//List<Integer> list3 = Arrays.asList(numbers);
		
		
		int[] array2 = {9,2,4,4,6,7};
		/*
		 * Arrays.stream(array) .boxed() .collect(Collectors.toList()); Stream<Integer>
		 * a = il.stream().filter(j->j%2==0);
		 */
		
		//convert int array to Integer list
		List<Integer> listInteger = new ArrayList<Integer>(array2.length);
		//a.forEach(System.out::println);
		//a.forEach(n->System.out.println(n));
		//Stream<Integer> sum = il.stream().max((i1,i2)-> 
		 // using lambda expression in place of comparator object
        Collections.sort(listInteger, (o1, o2) -> (o1 > o2) ? -1 :
                                       (o1 < o2) ? 1 : 0);
        listInteger.forEach(e->System.out.println("using lamda int sort:"+e));
		
		//Stream<Integer> sum = il.stream().sorted().distinct();
		//sum.forEach(System.out::println);
		
		Optional<Integer> b = il.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		System.out.println("using stream int sort 2nd last integer:"+b.get());
		//1.using lamda
		List<Product> list1 = list.stream().filter(p-> p.getPrice()>=5000f).collect(Collectors.toList());
		list1.forEach(System.out::println);
		
		List<Product> lp = list.stream().sorted((p1, p2)->(int)(p1.getPrice()- p2.getPrice())).collect(Collectors.toList());
		lp.forEach(System.out::println);
		
		//max price 
		   Product max = list.stream().max((p1,p2) -> p1.getPrice() > p2.getPrice() ? 1: -1).get();
		   System.out.println("max price: "+max.getPrice());
		   
		//2.using Comparator nth element based on price
		Optional<Product> list2 = list.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).skip(1).findFirst();
		//System.out.println(list2.get());
		if(list2.isPresent()) {
			System.out.println("checking null value:"+list2);
		}
		else {
			System.out.println("Element value not present");
		  }
		
		//Start wwith char
		List<String> sl = Arrays.asList("hello", "world", "Hello");
		int count = (int) sl.stream().filter(x-> x.startsWith("h")).count();
		System.out.println("start with h count is:"+count);
		
		/*
		 * predicate: return bollean
		 * Consumer: no result only consume an arg
		 * Function: input and output 
		 * Supllier: no input only supply
		 */
		
		// ex of Funtional Interface Consumer, Supplier, Predicate, Function
		 
		List<Product> list3 = new ArrayList<>();

		list3.add(new Product(1, "A", 5000f));
		list3.add(new Product(2, "B", 4000f));
		list3.add(new Product(3, "B", 6000f));
		
		Consumer<Product> con = (s)-> System.out.println("Consumer function used:"+s.getName());
		System.out.println("Without lambda expression\n");
		list3.forEach(con);
		
		System.out.println("\nWith lambda expression\n");
		list3.forEach(x -> System.out.println(x.getName()));
		
		//Predicate
		
		Predicate<Product> pre = (item) -> item.getPrice()>5000f;
		list3.stream().filter(pre).forEach(item -> System.out.println(item));
		
		//Supplier
		
		Supplier<Product> sup = ()-> new Product(4, "D", 7000f);
		System.out.println(list3.stream().filter(i -> i.getPrice()>5000f).findAny().orElseGet(sup));

	}

}
