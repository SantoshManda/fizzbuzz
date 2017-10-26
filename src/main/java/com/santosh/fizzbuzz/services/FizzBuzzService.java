package com.santosh.fizzbuzz.services;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface FizzBuzzService {
	
	public LinkedHashMap<String,ArrayList<Integer>> process(Integer UpperLimit);
	
}
