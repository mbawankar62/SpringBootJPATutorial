package com.mohit.LambadaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class ListWithlambdaExpression {
	 
	 public static void main(String args[]) {
		 
		List<Integer> list = new ArrayList<>();
		// Set<Integer>  list = new TreeSet<>();
		// Set<Integer>  list = new TreeSet<>((I1,I2)-> I1>I2?-1 : I1<I2?1 :0);
		 list.add(1);
		 list.add(10);
		 list.add(7);
		 list.add(5);
		 list.add(11);
		 
		// Collections.sort(list);
		 System.out.println("list with natural order :"+list);
		 
		// Collections.sort(list ,(I1,I2)->(I1>I2?-1 : I1<I2?1 : 0));
		 Collections.sort(list,(a,b)->a.compareTo(b));
		 System.out.println("list with customise order :"+list);
		 
	 }
 }

