package com.spring.java.config.demo;

import org.springframework.context.annotation.Primary;

@Primary
public class HappyFortuneService implements FortuneService{

	@Override
	public String getFortune() {
		return "Today is a happy day";
	}
}
