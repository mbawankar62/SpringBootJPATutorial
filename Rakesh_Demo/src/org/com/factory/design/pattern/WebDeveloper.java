package org.com.factory.design.pattern;

public class WebDeveloper implements Employee {

	@Override
	public int salary() {
		System.out.println("Gettimg web developer salary");
		return 40000;
	}

}
