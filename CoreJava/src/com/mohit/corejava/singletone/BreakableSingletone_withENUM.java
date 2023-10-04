package com.mohit.corejava.singletone;

import java.lang.reflect.Constructor;

enum BreakSingleton_Enum {

	INSTANCE;
	
}

public class BreakableSingletone_withENUM {

	public static void main(String[] args) throws Exception, SecurityException {
		
		
		BreakSingleton_Enum obj1= BreakSingleton_Enum.INSTANCE;
		System.out.println("obj1 hashcode"+obj1.hashCode());
		
		/*
		 class com.mohit.corejava.singletone.BreakableSingletone cannot access a member of class com.mohit.corejava.singletone.BreakSingleton with modifiers "private"
			at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:392)
		So need to add constructor.setAccessible(true)
		 */
		Constructor<BreakSingleton_Enum> constructor=BreakSingleton_Enum.class.getDeclaredConstructor();
		constructor.setAccessible(true); 
		BreakSingleton_Enum obj2=constructor.newInstance();
		System.out.println("obj2 hashcode"+obj2.hashCode());
	}

}

