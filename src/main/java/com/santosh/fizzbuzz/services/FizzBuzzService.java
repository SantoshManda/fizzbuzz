package com.santosh.fizzbuzz.services;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.santosh.fizzbuzz.CustomExceptions.UpperBoundLessThanZeroException;

public interface FizzBuzzService {
	
	public LinkedHashMap<String,ArrayList<Integer>> process(Integer UpperLimit) throws UpperBoundLessThanZeroException;
	
}
