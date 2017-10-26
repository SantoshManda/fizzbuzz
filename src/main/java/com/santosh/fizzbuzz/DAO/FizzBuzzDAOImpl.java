package com.santosh.fizzbuzz.DAO;

import java.util.ArrayList;
import java.util.HashMap;

public class FizzBuzzDAOImpl implements FizzBuzzDAO {

	@Override
	public HashMap<String, ArrayList<Integer>> calculate(Integer UpperLimit) {
		// TODO Auto-generated method stub
		if(UpperLimit.intValue() <= 0 || UpperLimit.intValue() == 1 || UpperLimit.intValue() == 2)
			return null;
		HashMap<String,ArrayList<Integer>> result = new HashMap<String,ArrayList<Integer>>();
		ArrayList<Integer> Fizzlist = new ArrayList<Integer>();
		ArrayList<Integer> Buzzlist = new ArrayList<Integer>();
		ArrayList<Integer> FizzBuzzlist = new ArrayList<Integer>();
		boolean r3=false,r5=false;
		for(int i = 3; i <= UpperLimit.intValue(); i++)
		{
			r3=false;
			r5=false;
			
			if( i%3 == 0)
			{
				Fizzlist.add(new Integer(i));
				r3=true;
			}
			if(i%5 == 0)
			{
				Buzzlist.add(new Integer(i));
				r5=true;
			}
			if(r3 && r5)
			{
				FizzBuzzlist.add(new Integer(i));
			}
		}
		
		result.put("Fizz", Fizzlist);
		result.put("Buzz", Buzzlist);
		result.put("FizzBuzz" , FizzBuzzlist);
		return result;
	}

}
