package com.mohit.springmvc.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
		//demo purpose
		@RequestMapping("/demoLogin")
		public String loginMessage(){
			//return "Hello World : Mohit ";
			return "customer-form" ;
		}
		
		 @RequestMapping(value = "/login", method = RequestMethod.GET)
		    public String showLoginPage(ModelMap model, @RequestParam String name) {
		        return "login";
		    }

		    @RequestMapping(value = "/login", method = RequestMethod.POST)
		    public String handleLogin(ModelMap model, @RequestParam String name) {
		        model.put("name", name);
		        return "welcome";
		    }
		
}
