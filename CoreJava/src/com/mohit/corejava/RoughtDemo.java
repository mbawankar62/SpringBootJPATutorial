package com.mohit.corejava;

import java.util.AbstractList;
import java.util.LinkedList;


class bike{
	int speed = 90 ;
}
class motorbike extends bike{
	int speed =200;
}

public class RoughtDemo {
	public static void main(String args[]) {
		bike b = new motorbike();
		System.out.println(b.speed);
		
	}
	
}
/*	
public class RoughtDemo {
	public static void main(String args[]) {

		// Creating an empty AbstractList
		AbstractList<String> list = new LinkedList<String>();

		// Using add() method to add elements in the list
		list.add("Geeks");
		list.add("for");
		list.add("Geeks");
		list.add("10");
		list.add("20");

		// Output the list
		System.out.println("AbstractList: " + list);

		// Remove the head using remove()
		list.remove(3);
		list.add("mohiyt");

		// Print the final list
		System.out.println("Final AbstractList: " + list);

		// getting the index of last occurrence
		// using lastIndexOf() method
		int lastindex = list.lastIndexOf("Geeks");

		// printing the Index
		System.out.println("Last index of A : " + lastindex);
	}
}

*/	