package com.santosh.fizzbuzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.santosh.fizzbuzz.services.*;
import com.santosh.fizzbuzz.DAO.*;

@Configuration
public class AppConfig {
	
	@Bean
	public FizzBuzzService fizzbuzzservice ()
	{
		return new FizzBuzzServiceImpl();
	}
	
	@Bean
	public FizzBuzzDAO fizzbuzzdao ()
	{
		return new FizzBuzzDAOImpl();
	}
	
}

