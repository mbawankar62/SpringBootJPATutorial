package org.com;

public class LamdaExample {
	
	public static void main(String args[]) {
		
		//without lamda
		Addable obj = new Addable(){
			
			public int add(int a, int b) {
				
				return a+b;
			}
		};
		System.out.println("without lamda sum :"+ obj.add(10, 20));
		
		//using lamda exp
		Addable obj1 = (a, b)-> {
			return a+b;
		};
		System.out.println("with lamda sum :"+ obj1.add(10, 20));
	}

}
