package com.santosh.fizzbuzz;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzbuzzApplicationTests {

	RestTemplate restTemplate = new RestTemplate();
	static final String ROOT_URL = "http://localhost:8080";
	
	@Test
	public void contextLoads() {
		
	}

	@Test
	public void testInput15()
	{
		
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
