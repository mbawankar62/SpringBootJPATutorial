package com.springboot.microservices.APIGateWay;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	//to customise route
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		/*
		 * Function<PredicateSpec, Buildable<Route>> routeFunction = p-> p.path("/get").uri("http://httpbin.org:80");
					return builder.routes()
							.route(routeFunction).build();
		 */
		/*//when any request comes from /get it will redirect to http://httpbin.org:80 with some header

		Function<PredicateSpec, Buildable<Route>> routeFunction = p-> p.path("/get")
				.filters(f -> f
						.addRequestHeader("MyHeader", "MyURI_Mohit")
						.addRequestParameter("Param", "MyValue_Mohit"))
						.uri("http://httpbin.org:80");
		return builder.routes()
				.route(routeFunction).build();
				//right click on routeFunction -->refactor-->Inline u will get below code format
		*/			
			//uri("lb://currency-exchange") it will name from eureka server and lb is load balancing
			/** 
			 * filters(f -> f.rewritePath
								(	"/currency-conversion-new/(?<segment>.*)", 
										"/currency-conversion-feign/${segment}"
								)
				/currency-conversion-new se jo bhi request aayegi wo currency-conversion-feign append hogi
			 */
		return builder.routes()
				.route(p -> p.path("/get")
							  .filters(f -> f.addRequestHeader("MyHeader", "MyURI")
								             .addRequestParameter("Param", "MyValue"))
						      .uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**").filters(f -> f.rewritePath
									("/currency-conversion-new/(?<segment>.*)","/currency-conversion-feign/${segment}"))
						      .uri("lb://currency-conversion"))
				.build();
	}

}
