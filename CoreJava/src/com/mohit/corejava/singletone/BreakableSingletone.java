package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

//youtube course https://www.youtube.com/watch?v=zHWusHi9Nt0&ab_channel=LearnCodeWithDurgesh
class BreakSingleton {

	// Static variable reference of single_instance of type Singleton
    private static BreakSingleton single_instance = null ;
  
   // public String s;
  
    private BreakSingleton()
    {
    	//s = "Hello I am a string part of Singleton class";
        System.out.println("inside private Constructor");
        //to overcome breaking of singletone you need to do follow this
        //1st Way
        if(single_instance != null) {
        	throw new RuntimeException("***You are trying to create already created instances***");
        }
    }
  
    // Static method
    // Static method to create instance of Singleton class
    /***
     * method is not syncronized so if new thread coming to getInstance()
     * everytime it will be new object for every thread
    */
    //public static synchronized BreakSingleton  getInstance()
    //if we do method level syncronization then all thread need to wait for previous thread even they have already created obj 
    //not not created object
    public static BreakSingleton  getInstance()
    {
    	synchronized (BreakSingleton.class) {
    		if (single_instance == null)
                single_instance = new BreakSingleton();
		}
  
        return single_instance;
    }
}

public class BreakableSingletone {

	public static void main(String[] args) throws Exception, SecurityException {
		
		
		BreakSingleton obj1= BreakSingleton.getInstance();
		System.out.println("obj1 hashcode::"+obj1.hashCode());
		
		/*
		 class com.mohit.corejava.singletone.BreakableSingletone cannot access a member of class com.mohit.corejava.singletone.BreakSingleton with modifiers "private"
			at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:392)
		So need to add constructor.setAccessible(true)
		 */
		Constructor<BreakSingleton> constructor=BreakSingleton.class.getDeclaredConstructor();
		constructor.setAccessible(true); //now if u remove "1st Way" from constructor it will not throw exception
		BreakSingleton obj2=constructor.newInstance();
		System.out.println("obj2 hashcode"+obj2.hashCode());
	}

}
