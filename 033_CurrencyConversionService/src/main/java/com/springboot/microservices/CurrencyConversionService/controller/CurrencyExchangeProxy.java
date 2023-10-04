package com.springboot.microservices.CurrencyConversionService.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.microservices.CurrencyConversionService.entity.CurrencyConversion;

/**
 * This class is required to talk with currency exchange microservices from conversion service
 * 
 */
/**
 *  http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10 
 *  to call above url we added below annotation with hardcoded url .to overcome this hardcoded
 *  url we use eureka server
 */
//@FeignClient(name="currency-exchange", url="localhost:8000")
/**
 * we use application name which we want to call .
 * if u see application.properties currency-exchange project "currency-exchange" is our application name 
**/
/** to remove "url="localhost:8000"" hardcoded things we use eureka server with below annotation **/
@FeignClient(name="currency-exchange")						  
public interface CurrencyExchangeProxy {

	//below method is matching with currency exchange param
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
													@PathVariable("to") String to);
}
