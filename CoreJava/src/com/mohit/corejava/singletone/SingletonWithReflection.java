package com.mohit.corejava.singletone;
import java.lang.reflect.Constructor;

//Singleton class
class Singleton1 {
	
	// public instance initialized when loading the class
	//public static Singleton1 instance = new Singleton1();
	public static Singleton1 instance;

	private Singleton1()
	{
		// private constructor
	}
}

public class SingletonWithReflection {

	public static void main(String[] args) {
		
		Singleton1 instance1 = Singleton1.instance;
		Singleton1 instance2 = null;
		try {

			Constructor[] constructors = Singleton1.class.getDeclaredConstructors();

			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (Singleton1) constructor.newInstance();
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
