package org.pedrohos.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {

	private List<MessageDTO> fieldErrors = new ArrayList<>();
	
    public ValidationErrorDTO() {}
 
    public void addFieldError(String message) {
        MessageDTO error = new MessageDTO(message);
        this.getFieldErrors().add(error);
    }

	public List<MessageDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<MessageDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
