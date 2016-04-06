package com.james.springboot.restspringboot.service.action;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.james.springboot.restspringboot.model.Greeting;

@RestController
public class GreetingController {
	
	private static BigInteger nextId;
	private static Map<BigInteger,Greeting> greetingMap;
	
	private static void addGreetToMap(Greeting greet){
		if(greetingMap == null){
			greetingMap = new HashMap<BigInteger,Greeting>();
			nextId = BigInteger.ONE;
		}
		
		greet.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		greetingMap.put(greet.getId(), greet);
	}
	
	static{
		Greeting g1 = new Greeting();
		g1.setText("I am g1");
		addGreetToMap(g1);
		
		Greeting g2 = new Greeting();		
		g2.setText("I am g2");
		addGreetToMap(g2);
		
	}
	
	@RequestMapping(value="/api/greetings",
				method=RequestMethod.GET,
				produces= MediaType.APPLICATION_JSON_VALUE)
			
	public ResponseEntity<Collection<Greeting>> getGreetings(){
		
		Collection<Greeting> list = greetingMap.values();
		
		return new ResponseEntity<Collection<Greeting>>(list,HttpStatus.OK);
	}
}
