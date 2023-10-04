package com.mohit.thread;
// Creating thread by creating the
// objects of that class
class ThreadJoining extends Thread
{
	@Override
	public void run()
	{
		System.out.println(" inside run()1: ");
		for (int i = 0; i < 2; i++)
		{
			try
			{
				System.out.println(" inside run2(): ");
				Thread.sleep(500);
				System.out.println("Current Thread inside run(): "
						+ Thread.currentThread().getName());
			}

			catch(Exception ex)
			{
				System.out.println("Exception has" +
								" been caught" + ex);
			}
			System.out.println(i);
		}
	}
}

public class ThreadExamples
{
	public static void main (String[] args)
	{

		// creating two threads
		ThreadJoining t1 = new ThreadJoining();
		ThreadJoining t2 = new ThreadJoining();
		ThreadJoining t3 = new ThreadJoining();

		// thread t1 starts
		t1.start();

		// starts second thread after when
		// first thread t1 has died.
		try
		{
			System.out.println("Current Thread after t1.start(): "
				+ Thread.currentThread().getName());
			t1.join();
		}

		catch(Exception ex)
		{
			System.out.println("Exception has " +
								"been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 has died.
		try
		{
			System.out.println("Current Thread after t2.start():: "
				+ Thread.currentThread().getName());
			t2.join();
		}

		catch(Exception ex)
		{
			System.out.println("Exception has been" +
									" caught" + ex);
		}

		t3.start();
	}
}
