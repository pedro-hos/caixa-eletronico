package org.pedrohos.model.exceptions;

public class NaoExisteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NaoExisteException(String message) {
		super(message);
	}

}
