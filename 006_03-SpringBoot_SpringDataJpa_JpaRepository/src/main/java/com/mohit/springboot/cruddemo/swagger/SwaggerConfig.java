package com.mohit.springboot.cruddemo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	// it will restrict actuator info to show in our swagger doc .
	/*
	@Bean
	public Docket mohitAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.luv2code.springboot.cruddemo.rest"))
				.paths(PathSelectors.regex("/empController.*")).build();
	}*/
	
	//if you want to show your custom info instead of swagger generated info like
	//add .apiInfo(apiInfo()) before .select()
	/*
		"info": {
					"description": "Api Documentation",
					"version": "1.0",
					"title": "Api Documentation",
					"termsOfService": "urn:tos",
					"contact": {},
					"license": {
					"name": "Apache 2.0",
					"url": "http://www.apache.org/licenses/LICENSE-2.0"
					}
				}
	 */
	
	@Bean
	public Docket mohitAPI()
	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.luv2code.springboot.cruddemo.rest"))
				.paths(PathSelectors.regex("/empController.*")).build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Products API").description("CreatedBy Mohit").license("licence").contact("7507421288").build();
	}

}
