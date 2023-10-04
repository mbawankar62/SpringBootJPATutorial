package com.mohit.corejava.singletone;

class Singleton {

	// Static variable reference of single_instance of type Singleton
    private static Singleton single_instance = null ;
  
   // public String s;
  
    private Singleton()
    {
    	//s = "Hello I am a string part of Singleton class";
        System.out.println("inside private Constructor");
    }
  
    // Static method
    // Static method to create instance of Singleton class
    /***
     * method is not syncronized so if new thread coming to getInstance()
     * everytime it will be new object for every thread
    */
    public static synchronized Singleton  getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
  
        return single_instance;
    }
}

public class SingletoneClass {
	
    // Main driver method
    public static void main(String args[])
    {
        /*
    	Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				 Singleton x = Singleton.getInstance();
			}
    		
    	});
    	
    	Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				 Singleton x = Singleton.getInstance();
			}
    		
    	});
    	
    	t1.start();
    	t2.start(); */
    	
    	Runnable r1 =()->{
			System.out.println("inside runnable r1 thread run method");
			 Singleton x1 = Singleton.getInstance();
			 System.out.println("Hashcode of r1 is " + x1.hashCode());
		};
		
		Runnable r2 =()->{
			System.out.println("inside runnable r2 thread run method");
			 Singleton x2 = Singleton.getInstance();
			 System.out.println("Hashcode of r1 is " + x2.hashCode());
		};
		
		Thread th1 = new Thread(r1);
		th1.start();
		Thread th2 = new Thread(r2);
		th2.start();
    	
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();
  
        // Printing the hash code for above variable as declared
       System.out.println("Hashcode of x is " + x.hashCode());
       System.out.println("Hashcode of y is " + y.hashCode());
       System.out.println("Hashcode of z is " + z.hashCode());
                          
  
        // Condition check
        if (x == y && y == z) {
  
            // Print statement
            System.out.println(
                "Three objects point to the same memory location on the heap i.e, to the same object");
        }
  
        else {
            // Print statement
            System.out.println(
                "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}
