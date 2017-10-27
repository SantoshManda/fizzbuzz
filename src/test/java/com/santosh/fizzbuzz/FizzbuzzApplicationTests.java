package com.santosh.fizzbuzz;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
		ArrayList<Integer> fizz = new ArrayList<Integer>();
		fizz.add(new Integer(3));
		fizz.add(new Integer(6));
		fizz.add(new Integer(9));
		fizz.add(new Integer(12));
		fizz.add(new Integer(15));
		ArrayList<Integer> buzz = new ArrayList<Integer>();
		buzz.add(new Integer(5));
		buzz.add(new Integer(10));
		buzz.add(new Integer(15));
		
		ArrayList<Integer> fizzbuzz = new ArrayList<Integer>();
		fizzbuzz.add(new Integer(15));
		
		assertThat(results,notNullValue());
		//JsonNode name = root.path("name");
		assertEquals(results.getFizz(),fizz);
		assertEquals(results.getBuzz(), buzz);	
		assertEquals(results.getFizzBuzz(), fizzbuzz);	
	}
	
	@Test
	public void testInput100() throws JsonParseException, JsonMappingException, IOException
	{
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/100";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		ObjectMapper mapper = new ObjectMapper();
		FizzBuzzResults results =  mapper.readValue(response.getBody(),FizzBuzzResults.class);
		
		ArrayList<Integer> fizzbuzz = new ArrayList<Integer>();
		fizzbuzz.add(new Integer(15));
		fizzbuzz.add(new Integer(30));
		fizzbuzz.add(new Integer(45));
		fizzbuzz.add(new Integer(60));
		fizzbuzz.add(new Integer(75));
		fizzbuzz.add(new Integer(90));
		
		assertThat(results,notNullValue());	
		assertEquals(results.getFizzBuzz(), fizzbuzz);	
	}
	
	@Test
	public void testInputNonNumeric()
	{
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/fsdfds";
		try{
		response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		}
		catch(RestClientException e)
		{
			assertTrue(e.getLocalizedMessage().contains("400"));
			assertEquals(response,null);
		}
	
	}
	
	@Test
	public void testInputSpecialCharecters()
	{
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/&*&%";
		try{
		response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		}
		catch(RestClientException e)
		{
			assertTrue(e.getLocalizedMessage().contains("400"));
			assertEquals(response,null);
		}
	}
	
	@Test
	public void testInput1() throws JsonParseException, JsonMappingException, IOException
	{
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/1";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertFalse(response.hasBody());		
	}
	
	@Test
	public void testInputNegative()
	{
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/-6";
		try{
		response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		}
		catch(RestClientException e)
		{
			assertTrue(e.getLocalizedMessage().contains("400"));
			assertEquals(response,null);
		}
	}
	
	@SuppressWarnings("unused")
	@Test(timeout=5000)
	public void testInputTimeOut()
	{
		RestTemplate restTemplate = new RestTemplate();
		//long start = System.currentTimeMillis();
		String ResourceUrl
		  = ROOT_URL+"/fizzbuzz"+"/1000000";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		 //long end = System.currentTimeMillis();
		 //System.out.println("Time elapsed is "+ (end -start));
	}
	
	@Test
	public void testInvalidPath()
	{
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		String ResourceUrl
		  = ROOT_URL+"/fiz";
		try{
		response
		  = restTemplate.getForEntity(ResourceUrl, String.class);
		}
		catch(RestClientException e)
		{
			assertTrue(e.getLocalizedMessage().contains("404"));
			assertEquals(response,null);
		}
	}
	
}
