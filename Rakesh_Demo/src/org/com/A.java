package org.com;

public interface A {

	public void show();
	public default void defaultMethod() {
		System.out.println("interface A");
	}
	
}
