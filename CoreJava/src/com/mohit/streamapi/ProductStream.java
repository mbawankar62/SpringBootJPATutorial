package com.mohit.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Product {

	private int id;
	private String ProductName;
	private int price;

	public Product() {
		super();
	}

	public Product(int id, String productName, int price) {
		super();
		this.id = id;
		ProductName = productName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", ProductName=" + ProductName + ", price=" + price + "]";
	}

}

public class ProductStream {

	public static void main (String args[]) {
		
		 List <Product> productsList = new ArrayList <Product> ();
	        // Adding Products
	        productsList.add(new Product(1, "HP Laptop", 25000));
	        productsList.add(new Product(2, "Dell Laptop", 30000));
	        productsList.add(new Product(2, "Dell Laptop v2", 30000));
	        productsList.add(new Product(3, "Lenevo Laptop", 28000));
	        productsList.add(new Product(4, "Sony Laptop", 28000));
	        productsList.add(new Product(5, "Apple Laptop", 90000));
	        
	        System.out.println(productsList);
	        // This is more compact approach for filtering data
	        productsList.stream().filter(product -> product.getPrice() == 30000)
	           					 .forEach(product -> System.out.println(product.getPrice()));
	        System.out.println("----------------------------------------------");
	        productsList.stream().filter(product -> product.getPrice()==30000).forEach(System.out::println);
	        System.out.println("----------------------------------------------");
	        productsList.stream().filter(product -> product.getPrice() ==30000)
	        								.collect(Collectors.toList()).forEach(System.out::println);
	        System.out.println("----------------------------------------------");
	        productsList.stream().filter(product -> product.getPrice() ==30000)
								 .collect(Collectors.toList()).forEach(p->System.out.println("product list without return type:"+p));
	        
	        System.out.println("----------------------------------------------");
	        //List<Integer> productPriceList2 = 	
	        productsList.stream().filter(product -> product.getPrice() < 30000)
							     .collect(Collectors.toList())
							     .forEach(p->System.out.println("product in list type without using map:"+p));
	        System.out.println("----------------------------------------------");
	        
	        //here we are not converting List<Product> to List<Integer>  so map() is not required
	        List<Product> productPriceList3 = productsList.stream().filter(product -> product.getPrice() < 30000)
							                              .collect(Collectors.toList());
	        System.out.println(" List<Product>:product List Type::"+productPriceList3);
	        
	        System.out.println("----------------------------------------------");
	        
	        //here we are converting List<Product> to List<Integer>  so map() is required
	        List<Integer> productPriceList2 = productsList.stream().filter(product -> product.getPrice() < 30000)
							.map(product -> product.getPrice()).collect(Collectors.toList());
	        System.out.println(" List<Integer>:product List Type::"+productPriceList2);
	        
	        System.out.println("----------------------------------------------");
	        
	        //Converting product List into Set
			Set<Integer> productPriceList1 = productsList.stream().filter(product -> product.getPrice() < 30000)
											.map(product -> product.getPrice()).collect(Collectors.toSet());
			System.out.println("product Set Type::"+productPriceList1);
			
			System.out.println("----------------------------------------------");
			// max() method to get max Product price
	        Product productA = productsList.stream()
	        				   .max((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1).get();

	        Product productBb = productsList.stream().collect(Collectors.maxBy(Comparator.comparing(Product::getPrice))).get();
	        
	        System.out.println("Max Price::"+productA.getPrice());
	        System.out.println("Max Price productBb::"+productBb);
	        
	        // min() method to get min Product price
	        Product productB = productsList.stream()
	            .max((product1, product2) -> product1.getPrice() < product2.getPrice() ? 1 : -1).get();
	        System.out.println("Min Price::"+productB.getPrice());
	        
	        System.out.println("----------------------------------------------");
	        
	        //The empty() method should be used in case of the creation of an empty stream:
	        	Stream<String> stream = Stream.empty();
	        	//stream.forEach(System.out::println);
	        	stream.forEach(s->System.out.println("empty stream::"+s));
	        	
	        System.out.println("----------------------------------------------");
	        
	        //Creating Stream from From Collections
	        Collection<String> collection = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
	        Stream<String> stream2 = collection.stream();
	        stream2.forEach(System.out::println);
	        System.out.println("----------------------------------------------");
	        List<String> list = Arrays.asList("JAVA", "J2EE", "Spring", "Hibernate");
	        Stream<String> stream3 = list.stream();
	        stream3.forEach(System.out::println);
	        System.out.println("----------------------------------------------");
	        Set<String> set = new HashSet<>(list);
	        Stream<String> stream4 = set.stream();
	        stream4.forEach(System.out::println);
	        System.out.println("----------------------------------------------");
	        
	        //Example 2: Streams are used to perform operations like filtering, mapping, collection result, etc:
	        //https://www.javaguides.net/2021/11/java-stream-api-interview-questions-and-answers.html
			List<String> lines = Arrays.asList("java", "c", "python");

			List<String> result = lines.stream() // convert list to stream
					.filter(line -> !"c".equals(line)) // we don't like c
					.collect(Collectors.toList()); // collect the output and convert streams to a List

			result.forEach(System.out::println);  
			
			
			//The map() function is an intermediate function that is used to perform map functional operations in Java. 
			//This means it can transform one type of object to others by applying a function.
			//Use map() function to convert one object to another object.
			//For example, if you have a List of String and you want to convert that to a List of Integer, 
			//you can use map() to do so.
			List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
	         
	        List<Integer> listOfIntegers = listOfStrings.stream()
	                        .map(Integer::valueOf)
	                        .collect(Collectors.toList());
	         
	        System.out.println("map(Integer::valueOf)::"+listOfIntegers);
	        
	        //Flatmap
	        //1st way
	        List<Integer> evens = Arrays.asList(2, 4, 6);
	        List<Integer> odds = Arrays.asList(3, 5, 7);
	        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);
	        List<Integer> numbers = Stream.of(evens, odds, primes)
	                				.flatMap(f -> f.stream()).collect(Collectors.toList());
	        System.out.println("flattend list: " + numbers);
	        
	        //2nd way
	        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6);
	        List<Integer> OddNumbers = Arrays.asList(3, 5, 7);
	        List<Integer> PrimeNumbers = Arrays.asList(2, 3, 5, 7, 11);
	        
	        List<Integer> flattenedList =Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers)
	        								.stream()
	        								.flatMap(l -> l.stream())
    										.collect(Collectors.toList());
	        System.out.println("The Structure after flattening is : " +flattenedList);
	        
	        //3rd way
	        List<List<Integer>> listOfListofInts =Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);
	  
	        System.out.println("The Structure before flattening is : " +listOfListofInts);
	                                                  
	        //Using flatMap for transformating and flattening.
	       List<Integer> listofInts  = listOfListofInts.stream()
	    		   										.flatMap(l -> l.stream())
	                                    				.collect(Collectors.toList());
	  
	        System.out.println("The Structure after flattening is : " +listofInts);
	        
	       //Creating a List of Strings
	        List<String> list_string = Arrays.asList("Geeks", "GFG","GeeksforGeeks", "gfg");
	  
	        // Using Stream flatMap(Function mapper)
	        list_string.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);
	                         
	}
}
