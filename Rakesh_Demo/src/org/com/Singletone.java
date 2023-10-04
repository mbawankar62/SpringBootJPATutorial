package org.com;

//Singletone means more than one obj can not be created

//1. instance is private and static
//2.All constructor should be private
//3. create static getInstance method.
public class Singletone {
	
	private static Singletone instance = null;
	
	public String s;
	
	private Singletone() {
		s = "singletone class created";
	}
	
	public static Singletone getInstance() {
		if(instance == null) {
			instance = new Singletone();
		}
		return instance;
	}

}
