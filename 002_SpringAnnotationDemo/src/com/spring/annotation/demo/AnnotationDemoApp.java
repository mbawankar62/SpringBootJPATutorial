package com.spring.annotation.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		//call the methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		//call daIly fortune method
		
		System.out.println(theCoach.getDailyFortune()); 
		
		
		Coach theCoach1 = context.getBean("pingPongCoach",Coach.class);
		System.out.println(theCoach1.getDailyWorkout());
		System.out.println(theCoach1.getDailyFortune());
		//close the context
		
		context.close();

	}

}
