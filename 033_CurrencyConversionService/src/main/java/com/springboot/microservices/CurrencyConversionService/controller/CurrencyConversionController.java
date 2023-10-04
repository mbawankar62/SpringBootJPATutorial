package com.springboot.microservices.CurrencyConversionService.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.microservices.CurrencyConversionService.entity.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	
	// TO call CurrencyExchange microservices we need to write below method.
	//to call one service we need this type of code :(
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
														  @PathVariable String to,
														  @PathVariable BigDecimal quantity)
	{
				
		//return new CurrencyConversion(10001L,from, to, quantity,BigDecimal.ONE,BigDecimal.ONE,"");
		HashMap<String, String> uriVariables = new HashMap<>();
	       						uriVariables.put("from",from);
	       						uriVariables.put("to",to);     
	     // Invoking Currency Exchange Microservice from Currency Conversion Microservice
	     ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity
	    	 ("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);  
	     
	     CurrencyConversion currencyConversion = responseEntity.getBody();
	        
	     return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,      
	                                	  currencyConversion.getConversionMultiple(),
	                                	  quantity.multiply(currencyConversion.getConversionMultiple()),
	                                	  currencyConversion.getEnvironment()+ " " + "rest template");             

	}
	
	
	//to overcome above tedious number of lines of code we we FEIGN to interact with services
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(	@PathVariable String from,
																@PathVariable String to,
																@PathVariable BigDecimal quantity) 
	{
				
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(),from, to, quantity, 
										currencyConversion.getConversionMultiple(), 
										quantity.multiply(currencyConversion.getConversionMultiple()), 
										currencyConversion.getEnvironment() + " " + "feign");
		
	}

}
