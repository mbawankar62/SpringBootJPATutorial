package org.com;

public class SingletoneDesignPattern {

	private static SingletoneDesignPattern obj = null;

	private SingletoneDesignPattern() {

	}

	public static SingletoneDesignPattern getInstance() {

		if (obj == null) {
			synchronized (SingletoneDesignPattern.class) {
				
				if(obj == null) {
				obj = new SingletoneDesignPattern();
			}
		  }
		}
		return obj;
	}

}
