package com.crx.examples.exception;

public class ConverterException  extends Exception{

	/**
	 * serial 1L
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct new ConverterException Exception and pass the msg as the parameter
	 * @param msg
	 * 
	 */
	public ConverterException(String msg){
		super(msg);
	}
	
}
