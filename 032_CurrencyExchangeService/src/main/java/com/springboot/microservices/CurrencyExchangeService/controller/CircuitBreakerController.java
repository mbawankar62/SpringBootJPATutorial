package com.springboot.microservices.CurrencyExchangeService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	/*
	 * RateLimiter :: block to frequent request
	 * TimeLimiter :: set a time limit when calling remote operation
	 * @Bulkhead :: avoid to many concurrent request
	 * cache :: store result of costly remote operation
	 */
	@GetMapping("/sample-api")
	/** @Retry :: 5 bar "http://localhost:8080/some-dummy-url" retry karega then hardcodedResponse return karega **/
	//@Retry(name = "default")
	// @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") 
	// @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	//CircuitBreaker:: try to hit url more number of time so if we see in log sampleApi method will not call but it will 
	//call hardcodedResponse() it will return default response if service is failure without disturbing it
	// @RateLimiter(name="default")/** RateLimiter means in 10 sec only 10000 api call **/
	@Bulkhead(name = "sample-api")//how many max concurrent calls 
	public String sampleApi() {
		logger.info("Sample api call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//					String.class);
//		return forEntity.getBody();
		return "sample-api";
	}

	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}