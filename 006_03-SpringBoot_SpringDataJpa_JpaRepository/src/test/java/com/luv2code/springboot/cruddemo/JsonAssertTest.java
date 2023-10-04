package com.luv2code.springboot.cruddemo;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	
	String actualResponse= "[\r\n"
			+ "    {\r\n"
			+ "        \"id\": 1,\r\n"
			+ "        \"firstName\": \"Mohit\",\r\n"
			+ "        \"lastName\": \"Bawankar\",\r\n"
			+ "        \"email\": \"mohit@gmail.com\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 2,\r\n"
			+ "        \"firstName\": \"Anita\",\r\n"
			+ "        \"lastName\": \"Rewatkar\",\r\n"
			+ "        \"email\": \"anita@gmail.com\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 3,\r\n"
			+ "        \"firstName\": \"Kunal\",\r\n"
			+ "        \"lastName\": \"Bawankar\",\r\n"
			+ "        \"email\": \"mohit@gmail.com\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 4,\r\n"
			+ "        \"firstName\": \"Anita\",\r\n"
			+ "        \"lastName\": \"Bawankar\",\r\n"
			+ "        \"email\": \"anita@gmail.com\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 6,\r\n"
			+ "        \"firstName\": \"Rupendra\",\r\n"
			+ "        \"lastName\": \"Rewatkar\",\r\n"
			+ "        \"email\": \"anita@gmail.com\"\r\n"
			+ "    }\r\n"
			+ "]";
	
	@Test
	public void jsonAssert() throws JSONException {
		
		String ExpectedResponse="[\r\n"
				+ "    {\r\n"
				+ "        \"id\": 1,\r\n"
				+ "        \"firstName\": \"Mohit\",\r\n"
				+ "        \"lastName\": \"Bawankar\",\r\n"
				+ "        \"email\": \"mohit@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": 2,\r\n"
				+ "        \"firstName\": \"Anita\",\r\n"
				+ "        \"lastName\": \"Rewatkar\",\r\n"
				+ "        \"email\": \"anita@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": 3,\r\n"
				+ "        \"firstName\": \"Kunal\",\r\n"
				+ "        \"lastName\": \"Bawankar\",\r\n"
				+ "        \"email\": \"mohit@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": 4,\r\n"
				+ "        \"firstName\": \"Anita\",\r\n"
				+ "        \"lastName\": \"Bawankar\",\r\n"
				+ "        \"email\": \"anita@gmail.com\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": 6,\r\n"
				+ "        \"firstName\": \"Rupendra\",\r\n"
				+ "        \"lastName\": \"Rewatkar\",\r\n"
				+ "        \"email\": \"anita@gmail.com\"\r\n"
				+ "    }\r\n"
				+ "]";
		JSONAssert.assertEquals(ExpectedResponse, actualResponse, false);
	}
	
	
}
