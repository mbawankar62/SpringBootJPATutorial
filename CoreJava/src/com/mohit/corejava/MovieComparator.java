package com.mohit.corejava;

/*
	Now, suppose we want sort movies by their rating and names also.
	When we make a collection element comparable(by having it implement Comparable),
	we get only one chance to implement the compareTo() method.
	The solution is using Comparator. 
*/
//A Java program to demonstrate Comparator interface
import java.util.*;

//A class 'Movie' that implements Comparable
class Movief implements Comparable<Movief> {
	private double rating;
	private String name;
	private int year;

	// Used to sort movies by year
	public int compareTo(Movief m) {
		return this.year - m.year;
	}

	// Constructor
	public Movief(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;
	}

	// Getter methods for accessing private data
	public double getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Movief [rating=" + rating + ", name=" + name + ", year=" + year + "]";
	}

}

//Class to compare Movies by ratings
class RatingCompare implements Comparator<Movief> {
	public int compare(Movief m1, Movief m2) {
		if (m1.getRating() < m2.getRating())
			return -1;
		if (m1.getRating() > m2.getRating())
			return 1;
		else
			return 0;
	}
}

//Class to compare Movies by name
class NameCompare implements Comparator<Movief> {
	public int compare(Movief m1, Movief m2) {
		return m1.getName().compareTo(m2.getName());
	}
}

//Driver class
public class MovieComparator {

	public static void main(String[] args) {
		ArrayList<Movief> list = new ArrayList<Movief>();
		list.add(new Movief("Force Awakens", 8.3, 2015));
		list.add(new Movief("Star Wars", 8.7, 1977));
		list.add(new Movief("Empire Strikes Back", 8.8, 1980));
		list.add(new Movief("Return of the Jedi", 8.4, 1983));

		// Sort by rating : (1) Create an object of ratingCompare
		// (2) Call Collections.sort
		// (3) Print Sorted list
		
		//Collections.sort(list);
		//System.out.println("Sorted by list direct:"+list);
		
		System.out.println("Sorted by rating");

		RatingCompare ratingCompare = new RatingCompare();
		Collections.sort(list, ratingCompare);
		for (Movief movie : list)
			System.out.println(movie.getRating() + " " + movie.getName() + " " + movie.getYear());

		// Call overloaded sort method with RatingCompare
		// (Same three steps as above)
		System.out.println("\nSorted by name");
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list, nameCompare);
		for (Movief movie : list)
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());

		// Uses Comparable to sort by year
		System.out.println("\nSorted by year");
		Collections.sort(list);
		for (Movief movie : list)
			System.out.println(movie.getYear() + " " + movie.getRating() + " " + movie.getName() + " ");
		
		System.out.println("--------------------------------");
		list.stream().sorted(Comparator.comparing(Movief::getName).reversed().thenComparingInt(Movief::getYear)
										.thenComparingDouble(Movief::getRating))
										.forEach(System.out::println);
	}
}