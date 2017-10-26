package com.santosh.fizzbuzz.services;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;

public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Autowired
	private FizzBuzzDAO dao;
	
	@Override
	public HashMap<String, ArrayList<Integer>> process(Integer UpperLimit) {
		// TODO Auto-generated method stub
		return dao.calculate(UpperLimit);
	}

}