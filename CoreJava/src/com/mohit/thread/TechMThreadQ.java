package com.mohit.thread;

public class TechMThreadQ {

public static void main(String[] args) {
		
		MultithreadingDemoRunnable r = new MultithreadingDemoRunnable();
		Thread th1 = new Thread(r);
		th1.start();
		Thread th2 = new Thread(r);
		th2.start();
		
	}

}

class MultithreadingDemoRunnable implements Runnable {
	public void run() {
		try {
		// Displaying the thread that is running 
		System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
		} catch (Exception e) { 
		// Throwing an exception 
		System.out.println ("Exception is caught"); } 
		} 
		
			/*public static void main(String args[]){
			
			MultithreadingDemoRunnable r = ()->{
			for(int i = 0 ;i<10;i++)
				System.out.println("Thread::"+i);
			);
			
			Thread th = new Thread(r);
			th.start();
			
			}*/
	}