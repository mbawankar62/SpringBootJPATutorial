package com.mohit.springboot.cruddemo.customactuatorEndpoint;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@org.springframework.boot.actuate.endpoint.annotation.Endpoint(id = "point")
public class Endpoint {

	private Map<String,String> mymap = new HashMap<>();
	
	public Endpoint() {
		mymap.put("name", "MyCustomEndPoind");
	}

	//u will see end point in actuator
	@ReadOperation
	public Map<String, String> getMymap() {
		return mymap;
	}
}
