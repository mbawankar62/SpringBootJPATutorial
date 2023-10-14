package com.mohit.corejava;

//Move all zeroes to end of array
//https://www.geeksforgeeks.org/move-zeroes-end-array/
public class ApexonTest {

	public static void main(String[] args) {

		int arr[] = { 1, 6, 0, 2, 0, 4, 9, 0 };
		// Output = [1 6 9 2 4 0 0 0]
		
		  int count = 0; 
		  for(int i = 0 ; i<arr.length ; i++)
		  
		  if (arr[i] != 0)
			  arr[count++] = arr[i];
		  
		  while (count < arr.length) 
			  arr[count++] = 0;
		  
		  for (int j=0; j< arr.length; j++) 
			  System.out.print(arr[j]+" ");
		  
		 
	/*
		int[] A = { 5, 6, 0, 4, 6, 0, 9, 0, 8 };
		int n = A.length;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] != 0) {

				int temp = A[j]; // temp=5
				A[j] = A[i]; // a[j]= 5
				A[i] = temp;
				j++;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " "); // Print the array
		} */

	}
}
