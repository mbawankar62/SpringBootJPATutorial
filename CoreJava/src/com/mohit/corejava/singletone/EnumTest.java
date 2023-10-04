package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

//Singleton class
enum Singleton11 {
	
	INSTANCE;
	// public instance initialized when loading the class
	//public static Singleton11 instance = new Singleton11();

	private Singleton11()
	{
		// private constructor
	}
}

public class EnumTest {

	public static void main(String[] args) {
		
		Singleton11 instance1 = Singleton11.INSTANCE;
		Singleton11 instance2 = null;
		try {

			Constructor[] constructors = Singleton11.class.getDeclaredConstructors();

			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (Singleton11) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());

		System.out.println("instance2.hashCode():- " + instance2.hashCode());

	}
}
