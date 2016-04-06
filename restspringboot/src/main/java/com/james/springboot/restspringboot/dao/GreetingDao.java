package com.james.springboot.restspringboot.dao;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.james.springboot.restspringboot.model.Greeting;

@Component
public class GreetingDao implements IGreetingDao {

	private static BigInteger nextId;
	private static Map<BigInteger,Greeting> greetingMap;
	
	
}
