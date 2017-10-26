package com.santosh.fizzbuzz.DAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface FizzBuzzDAO {
	
	public LinkedHashMap<String, ArrayList<Integer>> calculate(Integer UpperLimit);
	
}
