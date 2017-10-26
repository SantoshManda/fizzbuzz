package com.santosh.fizzbuzz.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.santosh.fizzbuzz.services.FizzBuzzService;


@RestController
@RequestMapping(value="/")
public class FizzBuzzController {
	
	@Autowired
	private FizzBuzzService Fs;
	
	@RequestMapping(value="/fizzbuzz/{UpperBound}", method=RequestMethod.GET)
	public HashMap<String,ArrayList<Integer>> fizController(@PathVariable("UpperBound") Integer UpperBound) throws MethodArgumentTypeMismatchException
	{
		return Fs.process(UpperBound);	
	}
	


}
