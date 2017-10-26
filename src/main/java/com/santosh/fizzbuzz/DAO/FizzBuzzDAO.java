package com.santosh.fizzbuzz.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public interface FizzBuzzDAO {
	
	public HashMap<String, ArrayList<Integer>> calculate(Integer UpperLimit);
	
}
