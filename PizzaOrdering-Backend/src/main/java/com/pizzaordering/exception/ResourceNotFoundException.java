package com.pizzaordering.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
