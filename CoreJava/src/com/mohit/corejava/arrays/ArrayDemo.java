package com.mohit.corejava.arrays;

import java.util.Arrays;

public class ArrayDemo {
	
	public static void main(String[] args) {
		
		// int intArray[]; //declaring array
		// intArray = new int[20]; // allocating memory to array

		// below declartion is not allowed we have to provide size
		// int arr1[]= new int[];

		int arr[] = new int[5];
		arr[0] = 10;
		arr[1] = 11;
		arr[2] = 102;
		arr[3] = 109;

		System.out.println("array size is :"+arr.length);
		
		System.out.println("array without for loop is :"+Arrays.toString(arr));
		
		for(int i=0 ;i<arr.length ; i++) {
			System.out.println("array at index "+i+" is "+arr[i]);
		}
		
		// Declaring array literal
		//int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
		System.out.println("---------------------------------------------");
		int[] literalarray = {10,11,12,13,14,15};

			System.out.println("literalarray size is :"+literalarray.length);
			
			for(int i=0 ;i<literalarray.length ; i++) {
				System.out.println("literalarray at index "+i+" is "+literalarray[i]);
			}
			System.out.println("array without for loop is :"+Arrays.toString(literalarray));
			
			System.out.println("***************array demo multiple operation for practise:******************");
			System.out.println("value at index 3: "+literalarray[3]);
			System.out.println("try to add value in array at index 7 it will throw Exception");
			//literalarray[7]=70;
			//System.out.println(" array after adding literalarray[7]=70 : "+ Arrays.toString(literalarray));
			System.out.println("try to update Array Value at index 5:");
			literalarray[5]=60;
			System.out.println("updated array :"+Arrays.toString(literalarray));
	}

}
