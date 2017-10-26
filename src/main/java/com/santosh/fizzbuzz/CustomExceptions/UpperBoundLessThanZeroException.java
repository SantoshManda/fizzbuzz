package com.santosh.fizzbuzz.CustomExceptions;

public class UpperBoundLessThanZeroException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1335791679976712878L;

	public UpperBoundLessThanZeroException(String message)
	{
		super(message);
	}
}
