package com.james.springboot.restspringboot.service.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloAngularPageAction {

	
	@RequestMapping(value="/angular/state",method=RequestMethod.GET)
	public String sayHello(Model model){
			
		return "/handson/angularAjax";
	}
	
}
