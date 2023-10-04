package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

enum Singletone_Enum {

    //private static Singletone_Enum INSTANCE = new Singletone_Enum();
	INSTANCE;

    private Singletone_Enum() {
    	System.out.println("Inside Private Constructor");
    }

	public static Singletone_Enum getInstance() {
		
		if (INSTANCE == null) {
			
			synchronized (Singletone_Enum.class) {
				if (INSTANCE == null) {
					//INSTANCE = new Singletone_Enum() ;
				}
			}
		}
		return INSTANCE;
	}


}

public class Singletone_withEnum {

	public static void main(String[] args) throws Exception {
		Singletone_Enum singleton1 = Singletone_Enum.getInstance();

        Constructor constructor = singleton1.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Singletone_Enum singleton2 = (Singletone_Enum) constructor.newInstance();

        if (singleton1 == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        
        System.out.println("Hashcode of singleton1 is " + singleton1.hashCode());
        System.out.println("Hashcode of singleton2 is " + singleton2.hashCode());

    }
}
