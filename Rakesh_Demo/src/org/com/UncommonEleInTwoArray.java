package org.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UncommonEleInTwoArray {

	public static void main(String[] args) {
		
		
		int[] Array1 = new int[] {10, 20, 30}; 
	    int[] Array2 = new int[] {20, 25, 30, 40, 50};//Output : 10 25 40 50
	    boolean contains = false;
	    List<Integer> results = new ArrayList<Integer>();


	    for(int i=0; i<Array1.length; i++) {
	        for(int j=0; j<Array2.length; j++) {
	            if(Array1[i]==Array2[j]) {
	                contains = true;
	                break;
	            }
	        }
	        if(!contains) {
	            results.add(Array1[i]);
	        }
	        else{
	            contains = false;
	        }
	    }

	    System.out.println("ele which are present in array1 and not in array2:"+results);
	    
	    //2nd aproach
	    
	    HashSet<Integer> hs = new HashSet<>();
	    
	    for(int v1 : Array1) {
	    	hs.add(v1);
	    }
	    for(int v2 : Array2) {
	    	
	    	if(!hs.contains(v2)) {
	    		System.out.println("Using hasgSet common element:"+v2);
	    	}
	    	else {
	    		//System.out.println(""+v2);
	    	}
	    }

	}

}
