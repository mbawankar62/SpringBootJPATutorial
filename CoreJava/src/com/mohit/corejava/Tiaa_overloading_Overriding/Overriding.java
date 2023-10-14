package com.mohit.corejava.Tiaa_overloading_Overriding;

class Animal {
	public void displayInfo() {
		System.out.println("I am an animal.");
	}
	
	protected void show() {
	      System.out.println("I am inside  protected animal.");
	   }
}

//https://www.programiz.com/java-programming/method-overriding
//Can we access the method of the superclass after overriding?
//Well, the answer is Yes. To access the method of the superclass from the subclass, we use the super keyword.

class Dog extends Animal {
	
	@Override
	public void displayInfo() {
		
		super.displayInfo(); //now it will call parent method will get below output
		/**I am an animal.
		   I am a dog.*/
		System.out.println("I am a dog.");
	}
	
	public void show() {
	      System.out.println("I am a dog.");
	   }
}

public class Overriding {

	public static void main(String[] args) {
		
		Dog d1 = new Dog();
	    d1.displayInfo(); 
	    d1.show(); 
	}

}
