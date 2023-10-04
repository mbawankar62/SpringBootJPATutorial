package com.mohit.thread;

public class TestThread extends Thread {

	public void run() {
		for(int i=0;i<=5;i++) {
			System.out.println("Hello:"+i);
		}
	}
	public static void main(String[] args) {
		
		TestThread t = new TestThread();
		t.start();
		TestThread t1 = new TestThread();
		t1.start();
	}

}
