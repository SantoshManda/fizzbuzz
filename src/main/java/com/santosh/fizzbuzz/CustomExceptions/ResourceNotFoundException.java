package com.santosh.fizzbuzz.CustomExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
/**
	 * 
	 */
	private static final long serialVersionUID = -6276323884744896269L;
	
public ResourceNotFoundException() {
this("Resource not found!");
}
public ResourceNotFoundException(String message) {
this(message, null);
}
public ResourceNotFoundException(String message, Throwable cause) {
super(message, cause);
}
}
