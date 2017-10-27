package com.santosh.fizzbuzz;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

//import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;




@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzbuzzApplicationTests {

	@Autowired
    private ApplicationContext appContext;
	
	RestTemplate restTemplate = new RestTemplate();
	static final String ROOT_URL = "http://localhost:8080";
	
	@Test
	public void contextLoads() {
		String[] beans = appContext.getBeanDefinitionNames();
		boolean b1=false,b2=false;
		for(String bean : beans)
		{
			if(bean.equals("fizzbuzzservice"))
				b1=true;
			if(bean.equals("fizzbuzzdao"))
				b2=true;
		}
		assertNotNull(beans);
		assertTrue(b1&&b2);
		//assertTrue(beans.toString().indexOf("fizzbuzzservice") > 0 && beans.toString().indexOf("fizzbuzzdao") > 0);
	}

	@Test
	public void testInput15() throws JsonProcessingException, IOException
	{
		
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/15";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		FizzBuzzResults results =  mapper.readValue(response.getBody(),FizzBuzzResults.class);
		assertThat(results,notNullValue());
		//JsonNode name = root.path("name");
		assertThat(results.getFizz(), notNullValue());
		assertThat(results.getBuzz(), notNullValue());	
		assertThat(results.getFizzBuzz(), notNullValue());	
	}
	
	@Test
	public void testInput100()
	{
		
	}
	
	@Test
	public void testInputNonNumeric()
	{
		
	}
	
	@Test
	public void testInputSpecialCharecters()
	{
		
	}
	
	@Test
	public void testInput1()
	{
		
	}
	
	@Test
	public void testInputNegative()
	{
		
	}
	
	@Test
	public void testInputTimeOut()
	{
		
	}
	
	@Test
	public void testInvalidPath()
	{
		
	}
	
}
