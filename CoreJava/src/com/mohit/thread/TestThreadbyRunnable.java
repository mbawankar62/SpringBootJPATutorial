package com.mohit.thread;

public class TestThreadbyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("Hello:"+i);
		}
	}
	
	public static void main(String[] args) {
		TestThreadbyRunnable t = new TestThreadbyRunnable();
		Thread th= new Thread(t);
		th.start();
	}

}
