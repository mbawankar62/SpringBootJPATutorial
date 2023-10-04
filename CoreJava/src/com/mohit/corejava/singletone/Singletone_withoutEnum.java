package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

class Singleton4 {

    private static Singleton4 INSTANCE = new Singleton4();

    private Singleton4() {}

	public static Singleton4 getInstance() {
		
		if (INSTANCE == null) {
			
			synchronized (Singleton4.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton4() ;
				}
			}
		}
		return INSTANCE;
	}

}

public class Singletone_withoutEnum {

	public static void main(String[] args) throws Exception {
		Singleton3 singleton1 = Singleton3.getINSTANCE();

        Constructor constructor = singleton1.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Singleton3 singleton2 = (Singleton3) constructor.newInstance();

        if (singleton1 == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }
        
        System.out.println("Hashcode of singleton1 is " + singleton1.hashCode());
        System.out.println("Hashcode of singleton2 is " + singleton2.hashCode());

    }
}
