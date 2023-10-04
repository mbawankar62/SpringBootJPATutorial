package com.spring.annotation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	//@Qualifier("sadFortuneService")
	private FortuneService fortuneService; 
	
	// define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	//@Qualifier with Setter Injection
	/*
	@Autowired
	public void setFortuneService(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
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
	
	//Using @Qualifier with Constructors
	/*
	@Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
        fortuneService = theFortuneService;
    }
    */
	
	/*
	 //Method Injection
	@Autowired
	public void doSomething(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomething() method");
		this.fortuneService = theFortuneService;
	}
	*/
	
	//You can also use the @Qualifier above the method name.
	//For example, here's the syntax
	/*
	@Autowired
	@Qualifier("randomFortuneService")
	public void doSomething(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomething() method");
		this.fortuneService = theFortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice yourbackhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
