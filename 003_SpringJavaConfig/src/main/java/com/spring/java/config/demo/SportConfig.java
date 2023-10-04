package com.spring.java.config.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.spring.java.config.demo")
/*
 * note : If we are defining individual beans then no need of @ComponentScan
 * 
 * Ex: SwimJavaConfigDemo
 */
@PropertySource("classpath:sport.properties")
//@PropertySource("classpath:mylogger.properties")
public class SportConfig {
	/*
	@Bean
	public MyLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {

		MyLoggerConfig myLoggerConfig = new MyLoggerConfig(rootLoggerLevel, printedLoggerLevel);

		return myLoggerConfig;
	}

	*/
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our swim coach AND inject dependency
	//if I am defining bean here then I don't need to 
	//@ComponentScan in SportConfig bcs individually its is done by @Bean
	@Bean
	public Coach swimCoach() {
		//SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		//return mySwimCoach;
		
		return new SwimCoach(sadFortuneService());
	}
	/*
	 * IF u r using this bean code then no need of @ComponentScan in SportConfig
	 * while running the JavaConfigDemoApp
	@Bean
	public Coach tennisCoach() {
		SwimCoach myTennisCoach = new SwimCoach(sadFortuneService());

		return myTennisCoach;
	}
	*/
}
