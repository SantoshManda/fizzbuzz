package com.santosh.fizzbuzz.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.springframework.beans.factory.annotation.Autowired;

import com.santosh.fizzbuzz.CustomExceptions.UpperBoundLessThanZeroException;
import com.santosh.fizzbuzz.DAO.FizzBuzzDAO;

public class FizzBuzzServiceImpl implements FizzBuzzService {

	@Autowired
	private FizzBuzzDAO dao;
	
	@Override
	public LinkedHashMap<String, ArrayList<Integer>> process(Integer UpperLimit) throws UpperBoundLessThanZeroException {
		// TODO Auto-generated method stub
		return dao.calculate(UpperLimit);
	}

}
