package com.mohit.corejava;

//Java program to demonstrate working of Comparator 
//interface and Collections.sort() to sort according 
//to user defined criteria. 
import java.util.*;

//A class to represent a student. 
class NewStudent {
	int rollno;
	String name, address;

	// Constructor
	public NewStudent(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

//Driver class 
public class ArrayVsCollections {
	public static void main(String[] args) {
		ArrayList<NewStudent> ar = new ArrayList<NewStudent>();
		ar.add(new NewStudent(111, "bbbb", "london"));
		ar.add(new NewStudent(131, "aaaa", "nyc"));
		ar.add(new NewStudent(121, "cccc", "jaipur"));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		// Collections.sort(ar);
		Collections.sort(ar, (s1, s2) -> (s1.rollno < s2.rollno) ? -1 : (s1.rollno > s2.rollno) ? 1 : 0);

		System.out.println("\nSorted by rollno");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}
}
