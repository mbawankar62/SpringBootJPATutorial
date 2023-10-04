package com.mohit.LambadaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer I1, Integer I2) {
		// TODO Auto-generated method stub
		return (I1>I2?-1 : I1<I2?1 : 0 );
	}
	
}

class ListWithoutlambdaExpression {
	 
	 public static void main(String args[]) {
		 
		 List<Integer> list = new ArrayList<>();
		 list.add(1);
		 list.add(10);
		 list.add(7);
		 list.add(5);
		 list.add(11);
		 
		 Collections.sort(list);
		 System.out.println("list with natural order :"+list);
		 
		 Collections.sort(list ,new MyComparator() );
		 System.out.println("list with customise order :"+list);
		 
	 }
 }

