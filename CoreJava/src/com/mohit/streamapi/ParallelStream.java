package com.mohit.streamapi;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {

	public static void main(String[] args)
    {
        // create a list
        List<String> list = Arrays.asList( "Hello ", "G", "E", "E", "K", "S!");
  
        list.stream().forEach(System.out::print);
        System.out.println("");
        list.parallelStream().forEach(System.out::print);
        
        //If we want to make each element in the parallel stream to be ordered,
        //we can use the forEachOrdered() method, instead of the forEach() method.
        System.out.println("");
        list.parallelStream().forEachOrdered(System.out::print);
    }
}
