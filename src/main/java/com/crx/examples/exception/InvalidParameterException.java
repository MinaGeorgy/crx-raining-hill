package com.crx.examples.exception;

/**
 * 
 * @author mina.nashed
 *
 */
public class InvalidParameterException extends Exception{

	/**
	 * serial 1L
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct new InvalidParameterException Exception and pass the msg as the parameter
	 * @param msg
	 * 
	 */
	public InvalidParameterException(String msg){
		super(msg);
	}
}
