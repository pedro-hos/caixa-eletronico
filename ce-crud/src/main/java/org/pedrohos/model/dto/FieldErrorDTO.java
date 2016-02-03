package org.pedrohos.model.dto;

public class FieldErrorDTO {
	
    private String message;
 
    public FieldErrorDTO( String message) {
        this.setMessage(message);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
