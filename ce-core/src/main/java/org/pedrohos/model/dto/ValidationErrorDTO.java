package org.pedrohos.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {

	private List<FieldErrorDTO> fieldErrors = new ArrayList<>();
	
    public ValidationErrorDTO() {}
 
    public void addFieldError(String message) {
        FieldErrorDTO error = new FieldErrorDTO(message);
        this.getFieldErrors().add(error);
    }

	public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
