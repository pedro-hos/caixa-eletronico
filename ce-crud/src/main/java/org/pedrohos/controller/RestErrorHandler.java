package org.pedrohos.controller;

import java.util.List;
import java.util.Locale;

import org.pedrohos.model.dto.ValidationErrorDTO;
import org.pedrohos.model.exceptions.JaExisteException;
import org.pedrohos.model.exceptions.NaoExisteException;
import org.pedrohos.model.exceptions.SaldoInsuficienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {
	
	private MessageSource messageSource;
	 
    @Autowired
    public RestErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(JaExisteException.class)
    public @ResponseBody ValidationErrorDTO jaExiste(JaExisteException ex) {
    	ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
    	validationErrorDTO.addFieldError(ex.getMessage());
    	return validationErrorDTO;
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(NaoExisteException.class)
    public @ResponseBody ValidationErrorDTO naoExiste(NaoExisteException ex) {
    	ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
    	validationErrorDTO.addFieldError(ex.getMessage());
    	return validationErrorDTO;
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(SaldoInsuficienteException.class)
    public @ResponseBody ValidationErrorDTO saldoInsuficiente(SaldoInsuficienteException ex) {
    	ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
    	validationErrorDTO.addFieldError(ex.getMessage());
    	return validationErrorDTO;
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
    	
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return processFieldErrors(fieldErrors);
    }
 
    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
    	
        ValidationErrorDTO dto = new ValidationErrorDTO();
 
        for (FieldError fieldError: fieldErrors) {
            dto.addFieldError(resolveLocalizedErrorMessage(fieldError));
        }
 
        return dto;
    }
 
    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale =  LocaleContextHolder.getLocale();
        return messageSource.getMessage(fieldError, currentLocale);
    }

}
