package com.jdot.customer.crud.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(){}
	
	public RecordNotFoundException(String message)
	{
		super(message);
	}

}
