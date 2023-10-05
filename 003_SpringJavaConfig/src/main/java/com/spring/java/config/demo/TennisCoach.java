package com.spring.java.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;
	
	//https://javainfinite.com/spring-boot/qualifier-vs-primary-with-examples/
	//@Primary  -->it is class level annotation and i mark in HappyFortune service
	//private FortuneService fortuneService2; 
	
	//@Qualifier has higher priority than @Primary annotation. 
	//In the above example we have used both @Primary and @Qualifier together – 
	 //Qualifier has taken higher priority than @Primary.
	
	// define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	*/
	/*
	@Autowired
	public void doSomething(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomething() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice your backhand volley";
	}

	
	  @Override 
	  public String getDailyFortune()
	  {
		   return fortuneService.getFortune();
		   
	  }
	  
	 

}
