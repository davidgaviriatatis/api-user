package com.nissum.apiuser.exceptions;

public class InternalServerErrorException extends RuntimeException{

	public InternalServerErrorException() {
    }

    public InternalServerErrorException(String message) {
        super(message);
    }
	
	private static final long serialVersionUID = 1L;

}
