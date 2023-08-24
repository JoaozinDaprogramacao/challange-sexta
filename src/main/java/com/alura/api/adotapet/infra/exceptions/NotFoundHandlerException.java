package com.alura.api.adotapet.infra.exceptions;

public class NotFoundHandlerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NotFoundHandlerException(String message) {
		super(message);
	}

}
