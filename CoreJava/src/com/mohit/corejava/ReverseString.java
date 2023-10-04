package com.mohit.corejava;

public class ReverseString {

	// Mohit

	public void reverse(String str) {
		if (str == null)
			System.out.println(str);

		else {

			// print reverse String
			System.out.println(str.charAt(str.length() - 1));
			reverse(str.substring(0, str.length() - 1));
		}
	}

	public static void main(String args[]) {

		ReverseString result = new ReverseString();
		result.reverse("mohit");

	}

}
