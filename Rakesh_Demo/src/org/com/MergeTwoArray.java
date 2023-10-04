package org.com;

import java.util.Arrays;
import java.util.HashSet;

public class MergeTwoArray {

	public static void main(String[] args) {

		int[] a = { 10, 20, 30, 40 };
        int[] b = { 50, 60, 40, 80 };
        int a1 = a.length;
		int b1 = b.length;
        usingInbuild(a, b, a1, b1);
        withoutInbuild(a, b, a1, b1);
        findMissing(a, b, a1, b1);
	}
	
  public static void withoutInbuild(int[] a, int [] b, int a1, int b1) {
		
		int c1 = a1+b1;
		int[] c = new int[c1];
		
		for(int i = 0; i<=a.length-1; i++) {
			c[i]=a[i];
		}
		
		for(int j = 0; j<=a.length-1; j++) {
			c[a1+j]=a[j];
		}
		
		for(int k = 0; k<=a.length-1; k++) {
			System.out.println("withoud inbuild method:"+c[k]);
		}
		
		
	}

	public static void usingInbuild(int[] a, int [] b, int a1, int b1) {
		
		
		int c1 = a1+b1;
		
		int[] c = new int[c1];
		
		for(int i= 0; i<=c.length-2; i++) {
			if(c[i]!=c[i+1]) {
				System.out.println("after merge finding uniq value:"+c[i]);
			}
		}
		HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i <c1; i++) {
            s.add(c[i]);
	}
        System.out.println("hassett:"+c.toString());
		System.arraycopy(a, 0, c, 0, a1);
		System.arraycopy(b, 0, c, 0, b1);
		System.out.println(Arrays.toString(c));
		
	}
	
	public static void findMissing(int[] a, int [] b, int a1, int b1) {
		
		
		 HashSet<Integer> s = new HashSet<>();
	        for (int i = 0; i <b1; i++)
	            s.add(b[i]);
	         
	        // Print all elements of first array
	        // that are not present in hash table
	        for (int i = 0; i < a1; i++)
	            if (!s.contains(a[i]))
	                System.out.print(a[i] + " ");
	    
		
	}

}
