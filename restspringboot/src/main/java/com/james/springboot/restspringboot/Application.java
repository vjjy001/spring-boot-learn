package com.james.springboot.restspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Spring boot Main entry
 *
 */

@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
