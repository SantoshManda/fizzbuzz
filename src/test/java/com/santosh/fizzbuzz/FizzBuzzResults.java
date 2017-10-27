package com.santosh.fizzbuzz;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;



public class FizzBuzzResults{


	@JsonProperty(value="Fizz")
	private List<Integer> fizz=new ArrayList<>();

	@JsonProperty(value="Buzz")
	private List<Integer> buzz=new ArrayList<>();;
	
	@JsonProperty(value="FizzBuzz")
	private List<Integer> fizzBuzz=new ArrayList<>();
	
	public FizzBuzzResults()
	{
		
	}
	
	public List<Integer> getFizz() {
		return fizz;
	}
	
	public void setFizz(List<Integer> fizz) {
		this.fizz = fizz;
	}
	
	public List<Integer> getBuzz() {
		return buzz;
	}
	
	public void setBuzz(List<Integer> buzz) {
		this.buzz = buzz;
	}
	
	public List<Integer> getFizzBuzz() {
		return fizzBuzz;
	}
	
	public void setFizzBuzz(List<Integer> fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

	@Override
	public String toString() {
		return "FizzBuzzResults [Fizz=" + fizz.toString() + ", Buzz=" + buzz.toString() + ", FizzBuzz=" + fizzBuzz.toString() + "]";
	}
	
}
