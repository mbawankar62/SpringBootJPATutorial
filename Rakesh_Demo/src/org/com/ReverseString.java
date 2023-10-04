package org.com;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {

		String s= "Hello world";
		String newStr = " ";
		char c;
		for(int i = 0; i<s.length(); i++) {
			c= s.charAt(i);
			newStr = c+newStr;//"" +H, newStr=e+H = eH
			//newStr = newStr+c;
		}
		
		System.out.println("reverse each char and position:"+newStr);
		/*
		String originalStr = "Hello Word";
		String reversedStr = "";

		for (int i = 0; i < originalStr.length(); i++) {
			
			System.out.println("originalStr.charAt(i) : " + originalStr.charAt(i) );
			reversedStr = originalStr.charAt(i) + reversedStr;
			System.out.println("reversedStr " + reversedStr );
		}
		System.out.println("Reversed string: " + reversedStr);*/
		
		reverseStingPreservedPosition(s);
		reverseStingPreservedPosition2(s);
		reverseStingPreservedPosition3(s);
		
		reverseWord(s);
		
		 String str = "Mohit Bawankar";
		 ReverseString obj = new ReverseString();
		 System.out.println("Reverse Word using recusrion::");
		 obj.reverse(str);
		 
	}
	
	//input :Hello Word
	//output:olleH dlrow
	//1st Way::
	public static void reverseStingPreservedPosition(String s1) {
		String s[] = s1.split(" ");
		String reverse = " ";
		for(String value: s) {
			StringBuilder sb = new StringBuilder(value);
			sb.reverse();
			 reverse+= sb+" ";
			}
		System.out.println("reverse String Preserved Position:"+reverse);
	}
	 
	public static void reverseStingPreservedPosition2(String s1) {
		
	String result = Arrays.asList(s1.split(" ")).stream()
					.map(s -> new StringBuilder(s).reverse())
					.collect(Collectors.joining(" "));
	
    System.out.println("reverse individual string with preserve position lambda::"+result);
    
	}
    // reverses individual words of a string with preserve position
	//2nd Way ::
    public static void reverseStingPreservedPosition3(String str)
    {
        Stack<Character> st = new Stack<Character>();
 
        // Traverse given string and push all
        // characters to stack until we see a space.
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ')
                st.push(str.charAt(i));
 
            // When we see a space, we print
            // contents of stack.
            else {
                while (st.empty() == false) {
                    System.out.print(st.pop());
                }
                System.out.print(" ");
            }
        }
        // Since there may not be space after
        // last word.
        while (st.empty() == false) {
            System.out.print(st.pop());
        }
    }
	
    //reverse words only
	public static void reverseWord(String s2) {
		String s[] = s2.split(" ");
		String reverse = " ";
		for(int i=s.length-1; i>=0; i--) {
			reverse+= s[i]+" ";
		}
		System.out.println();
		System.out.println("reverse Word:"+reverse);
	}
	
	// Java program to reverse a string using recursion
	 
	
	    /* Function to print reverse of the passed string */
	    void reverse(String str)
	    {
	        if ((str==null)||(str.length() <= 1))
	           System.out.println(str);
	        else
	        {
	        	//System.out.println(str);
	            System.out.print(str.charAt(str.length()-1));
	            reverse(str.substring(0,str.length()-1));
	        }
	    }
	     
  
	}


