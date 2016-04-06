package com.james.springboot.restspringboot.service.action;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.james.springboot.restspringboot.model.Greeting;

@Controller
public class HelloLeafAction {

	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(Model model){
		String name = "James";
		model.addAttribute("name", name);
		
		return "/handson/hello";
	}
	
	
	@RequestMapping(value="/hello/list",method=RequestMethod.GET)
	public String listGreeting(Model model){
		
		List<Greeting> list = new ArrayList<Greeting>();
		for(int i=1;i<100;i++){
			Greeting greeting = new Greeting();
			greeting.setId(BigInteger.valueOf(i));
			greeting.setText("hello"+i);
			list.add(greeting);
		}
		
		model.addAttribute("list", list);
		
		return "/handson/listGreeting";
	}
	
}
