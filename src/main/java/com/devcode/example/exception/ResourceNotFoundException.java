package com.devcode.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	private static final long serialVeersionUID = 1L;
	private String msg;
	
	public ResourceNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
}