package com.springjpa.car.accountmanagement.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springjpa.car.accountmanagement.model.ErrorMessage;


@ControllerAdvice
public class AccountAppException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex){
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription==null)errorMessageDescription=ex.toString();
		ErrorMessage er=new ErrorMessage(new Date() ,ex.getMessage(),"EXCEPTION");
		return new ResponseEntity<>(er,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value= {UserException.class})
	public ResponseEntity<Object> handleUserExceptionException(UserException ex,WebRequest request){
		
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription==null)errorMessageDescription=ex.toString();
		ErrorMessage er=new ErrorMessage(new Date() ,ex.getMessage(),"NOT_FOUND");
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value= {UserAlreadyExistException.class})
	public ResponseEntity<ErrorMessage> handleUserAlreadyExceptionException(UserAlreadyExistException ex,WebRequest request){
		
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription==null)errorMessageDescription=ex.toString();
		ErrorMessage er=new ErrorMessage(new Date() ,ex.getMessage(),"CONFLICT");
		return new ResponseEntity<ErrorMessage>(er,HttpStatus.CONFLICT);
	    
	}
	
	@ExceptionHandler(value= {MethodArgumentNotValidException.class})
	public ResponseEntity<Object> handleUserExceptionExceptionValidate(MethodArgumentNotValidException ex,WebRequest request){
		
		String errorMessageDescription=ex.getLocalizedMessage();
		if(errorMessageDescription==null)errorMessageDescription=ex.toString();
		ErrorMessage er=new ErrorMessage(new Date() ,ex.getMessage(),"NOT_FOUND");
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
	}
}
