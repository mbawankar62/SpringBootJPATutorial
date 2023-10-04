package com.springcore.springIOC.usingXML.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		/** IoC Start **/
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		//IoC
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(trackCoach.getDailyWorkout());
		
		/** IoC End **/
		
		/* DI */
		Coach baseBallCoach = context.getBean("mybaseballCoach", Coach.class);
		System.out.println(baseBallCoach.getDailyWorkout());		
		System.out.println(baseBallCoach.getDailyFortune());
		
		
		CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		// ... let's come back to this ...
		System.out.println(cricketCoach.getDailyWorkout());		
		System.out.println(cricketCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(cricketCoach.getEmailAddress());		
		System.out.println(cricketCoach.getTeam());
		
		// close the context
		context.close();
	}

}
