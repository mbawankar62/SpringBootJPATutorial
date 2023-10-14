package com.luv2code.springboot.cruddemo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mohit.springboot.cruddemo.entity.Employee;
import com.mohit.springboot.cruddemo.rest.EmployeeRestController;
import com.mohit.springboot.cruddemo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void findAll() throws Exception {
		
		when(employeeService.findAll()).thenReturn(Arrays.asList(new Employee("Rupendra","Rewatkar","anita@gmail.com")));
		RequestBuilder request = MockMvcRequestBuilders.get("/employees").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockmvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(" {"
						+ "        \"firstName\": \"Rupendra\",\r\n"
						+ "        \"lastName\": \"Rewatkar\",\r\n"
						+ "        \"email\": \"anita@gmail.com\"\r\n"
						+ "    }\r\n"
						+ "]"))
				.andReturn();
		
		//assertEquals("Hello World",result.getResponse().getContentAsString() );
		
	}
	
	@Test
	public void testSave() throws Exception{
		
		//doCallRealMethod().when(mockedUserRepository).updateName(anyLong(), anyString());
		//userService.updateName(1L,"calling real method");
		//verify(mockedUserRepository, times(1)).add(1L,"calling real method");
		
		
		doCallRealMethod().when(employeeService).save(any());
		 
		Employee emp = new Employee();
		emp.setFirstName("mohit in test class");
		
		employeeService.save(emp);
		
		verify(employeeService, times(1));
	}

}
