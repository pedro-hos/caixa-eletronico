package org.pedrohos.model.dto;

public class MessageDTO {
	
    private String message;
 
    public MessageDTO() { }
    
    public MessageDTO( String message) {
        this.setMessage(message);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
