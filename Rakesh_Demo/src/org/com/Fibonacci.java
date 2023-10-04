package org.com;

public class Fibonacci {

	public static void main(String[] args) {
		
		int N=10;
		int a =0, b=1, sum=0,count= 0;
		//Input: N = 10 
		//Output: 0 1 1 2 3 5 8 13 21 34 
		/*for(int i= 0; i<9; i++) {
			System.out.println(c);
			c= a+b;
			//System.out.println(c);
			a=b;
			b=c;
		}*/
		
		while(count<N) {
			
			System.out.println(a+" ");
			sum= a+b;
			a=b;
			b=sum;
			count=count+1;
		}
		

	}

}
