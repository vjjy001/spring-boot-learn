package com.james.springboot.restspringboot.dbconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Bean(name="blsDBsource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name="localDBsource")
	@ConfigurationProperties(prefix="spring.local.datasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	 @Bean(name = "blsJDBC")
	 @Autowired
	  public JdbcTemplate blcJdbcTemplate(@Qualifier("blsDBsource") DataSource source) {
	        return new JdbcTemplate(source);
	    }

	   @Bean(name = "localJDBC")
	   @Autowired	    
	   public JdbcTemplate localJdbcTemplate(@Qualifier("localDBsource") DataSource source) {
	        return new JdbcTemplate(source);
	    }

}
