package com.mohit.corejava;

class ParentTest {

	public int x = 5;
	public int y = 15;

	public void show() {
		System.out.println("X = " + this.x);
	}
}

class Child extends ParentTest {

	public int x = 6;

	@Override
	public void show() {
		System.out.println("X = " + this.x);
	}
}

public class JohnDeerInterview {
	public static void main(String[] args) {

		Child c = new Child();
		ParentTest ch = new Child();
		ch.show(); // Line1 //6
		System.out.println("X = " + ch.x); // Line2 //6// wrong
		System.out.println("ch.y = " + ch.y);
		System.out.println("y = " + c.y);

	}

}
