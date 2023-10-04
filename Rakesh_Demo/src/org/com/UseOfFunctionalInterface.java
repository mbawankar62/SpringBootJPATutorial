package org.com;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

 class Person {
	 private String Name;

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
 }
 
public class UseOfFunctionalInterface {

	public static void main(String[] args) {
		//Predicate: return boolean
		Predicate<String> checkLenth = str ->str.length()>5;
		System.out.println("Predicate Interface :"+checkLenth.test("Hello java code"));
		System.out.println("Predicate Interface :"+checkLenth.test("Hello"));
		
		//Consumer: Only consume
		Person p = new Person();
		Consumer<Person> con = s-> s.setName("Rakesh ");
		con.accept(p);
		System.out.println("Consumer Interface :"+p.getName());
		
		//Function: both input and output
		Function<Integer, String> fun = x->x*10+": Data multiplied by 10";
		System.out.println(fun.apply(2));
		
		//Supply: Supply only output
		Supplier<Double> getRandomNo = ()->Math.random();
		System.out.println(getRandomNo.get());//no input

	}

}
