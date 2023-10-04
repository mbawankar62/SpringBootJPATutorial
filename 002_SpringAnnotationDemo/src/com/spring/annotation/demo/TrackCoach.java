package com.spring.annotation.demo;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "From TrackCoach....Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return " From TrackCoach ..........getDailyFortuneService";
	}

}









