package org.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingBasisOfName {
	
	public static void main(String args[]) {
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1, "HP", 25000f));
		list.add(new Product(3, "Dell", 30000f));
	    list.add(new Product(2, "Lenovo", 35000f));
	    
	    //with lamda
	    Collections.sort(list,(p1,p2)->{  
	        return p1.getName().compareTo(p2.getName());  
	        });  
	    list.forEach(
	    		(n)->System.out.println(n.getName()));
	   
	    //all details having more than 25000 price
	   Stream<Product>  intValue = list.stream().filter(p-> p.getPrice()>25000);
	   intValue.forEach(n-> System.out.println("using filter:"+n.getId()+":"+n.getPrice()+":"+n.getName()));
	   
	   //sum of all price
	   Double sum = list.stream().collect(Collectors.summingDouble(p->p.getPrice()));
	   System.out.print("sum:"+sum);
	   
	   //max price 
	   Product max = list.stream().max((p1,p2) -> p1.getPrice() > p2.getPrice() ? 1: -1).get();
	   System.out.println("max price: "+max.getPrice());
	   
	  long count = list.stream().filter(p->p.getPrice()>25000).count();
	  System.out.println("Cont:"+count);
	  
	  List<Float> list2 = list.stream()
			  .filter(p -> p.getPrice() > 25000)
			  .map(p -> p.getPrice())
			  .collect(Collectors.toList());
	  System.out.println(list2);
	  
	  List<Float> productPriceList =   
              list.stream()  
                          .filter(p -> p.getPrice() > 30000) // filtering data  
                          .map(Product::getPrice)         // fetching price by referring getPrice method  
                          .collect(Collectors.toList());  // collecting as list  
      System.out.println("method reference:"+productPriceList);  
      
      
      Set<Float> removeDuplicate =   
              list.stream()  
              .filter(product->product.getPrice() < 30000)   // filter product on the base of price  
              .map(product->product.getPrice())  
              .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
          System.out.println(removeDuplicate); 
          
	  // using Comparator customize sorting without lamda
	   // Collections.sort(list, new Product());
	    
	    for(Product obj: list) {
	    	
	    	if(obj.getPrice()>=28000) {
	    		System.out.println("java7:"+obj.getId()+" "+obj.getName()+" "+obj.getPrice());
	    	}
	    	
	    }
	    
	    Optional<Product> pro = list.stream()
	    		.sorted(Comparator.comparingDouble(Product::getPrice).reversed()).skip(1).findFirst();
	    System.out.println("2nd large price details:"+pro.get()); 
	}

}
