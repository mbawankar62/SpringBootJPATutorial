package com.spring.java.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	//@Qualifier("happyFortuneService")
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService; 
	
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
