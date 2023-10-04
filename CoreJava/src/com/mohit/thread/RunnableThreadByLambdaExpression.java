package com.mohit.thread;

public class RunnableThreadByLambdaExpression {

	public static void main(String[] args) {

		Runnable r =()->{
			System.out.println("inside runnable thread run method");
			for(int i=0;i<5;i++) {
				System.out.println("Thread:"+i);
			}
		};
		
		Thread th = new Thread(r);
		th.start();
	}

}
