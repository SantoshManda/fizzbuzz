package com.santosh.fizzbuzz;


import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;




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
