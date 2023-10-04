package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

//https://dzone.com/articles/java-singletons-using-enum
//https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
class Singleton3 {

    private static Singleton3 INSTANCE = new Singleton3();

    private Singleton3() {}

	public static Singleton3 getInstance() {
		
		if (getINSTANCE() == null) {
			
			synchronized (Singleton.class) {
				if (getINSTANCE() == null) {
					setINSTANCE(new Singleton3());
				}
			}
		}
		return getINSTANCE();
	}

	public static Singleton3 getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(Singleton3 iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

}

public class SingletonWithReflection2 {

	public static void main(String[] args) throws Exception {
		Singleton3 singleton = Singleton3.getINSTANCE();

        Constructor constructor = singleton.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);

        Singleton3 singleton2 = (Singleton3) constructor.newInstance();

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

       // singleton.setValue(1);
       // singleton2.setValue(2);

       // System.out.println(singleton.getValue());
       // System.out.println(singleton2.getValue());

    }
}
