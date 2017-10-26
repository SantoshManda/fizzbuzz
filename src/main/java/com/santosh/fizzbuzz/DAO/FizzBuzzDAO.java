package com.santosh.fizzbuzz.DAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.santosh.fizzbuzz.CustomExceptions.UpperBoundLessThanZeroException;

public interface FizzBuzzDAO {
	
	public LinkedHashMap<String, ArrayList<Integer>> calculate(Integer UpperLimit) throws UpperBoundLessThanZeroException;
	
}
