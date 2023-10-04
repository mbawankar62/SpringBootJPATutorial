package com.mohit.corejava;

import java.util.Arrays;

public class SumOfTwoNumberIsTEN {

	public static void main(String[] args) {

		int[] arrayOfIntegers = { 0, 5, 4, 6, 3, 7, 2, 10 };

		Arrays.sort(arrayOfIntegers);
		System.out.println(Arrays.toString(arrayOfIntegers));

		int left = 0;
		int right = arrayOfIntegers.length - 1;

		while (left < right) {
			int leftVal = arrayOfIntegers[left];
			int rightVal = arrayOfIntegers[right];
			int sum = leftVal + rightVal;

			if (sum == 10) // check to see if equal to 10
			{
				System.out.println(arrayOfIntegers[left] + "," + arrayOfIntegers[right]);
				right--;
				left++;
			}
			if (sum > 10) // if sum is more than 10, move to lesser number
			{
				right--;
			}
			if (sum < 10) // if sum is less than 10, move to greater number
			{
				left++;
			}

		}

	}
}
