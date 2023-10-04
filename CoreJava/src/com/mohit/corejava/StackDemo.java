package com.mohit.corejava;

public class StackDemo {
	int top;
	int maxCapacity = 500;
	int stackAarry[] = new int[maxCapacity];

	public boolean push(int number) {

		if (top >= (maxCapacity - 1)) {
			System.out.println("StackFull");
			return false;
		}

		else {
			System.out.println("Pushing Into Stack");
			stackAarry[++top] = number;
			return true;
		}

	}

	public int pop() {

		if (top < 0 ) {
			System.out.println("StackUnderflow");
			return 0;
		}

		else {

			int  number = stackAarry[top--];
			 return number;
		}
	}

	public int peek()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int number = stackAarry[top];
			return number;
		}
	}
	void print() {
		for (int i = top; i > -1; i--) {
			System.out.print(" " + stackAarry[i]);
		}

	}
	

	public static void main(String args[]) {

		StackDemo s = new StackDemo();
		s.push(60);
		s.push(200);
		s.push(900);
		s.push(602);
		s.push(2001);
		s.push(9001);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Top element is :" + s.peek());
		System.out.print("Elements present in stack :");
		s.print();
	}

}
