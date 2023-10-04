package com.mohit.corejava;

import java.util.ArrayList;
import java.util.Collections;

//Driver class
public class MovieTest
{
	public static void main(String[] args)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("ForceAwakens", 8.3, 2015));
		list.add(new Movie("StarWars", 8.7, 1977));
		list.add(new Movie("EmpireStrikes Back", 8.8, 1980));
		list.add(new Movie("ReturnoftheJedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (Movie movie: list)
		{
			System.out.println(movie.getName() + " " +
							movie.getRating() + " " +
							movie.getYear());
		}
	} 
}