package org.pedrohos.model.exceptions;

public class JaExisteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public JaExisteException(String message) {
		super(message);
	}

}
