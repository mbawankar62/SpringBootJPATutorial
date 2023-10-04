package org.com;

public interface B {

	public void show();
	public default void defaultMethod() {
		System.out.println("interface B");
	}
	
}
