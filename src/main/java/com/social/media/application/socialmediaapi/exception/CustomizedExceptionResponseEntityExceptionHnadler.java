package com.social.media.application.socialmediaapi.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.social.media.application.socialmediaapi.user.userNotFoundException;

@ControllerAdvice
public class CustomizedExceptionResponseEntityExceptionHnadler extends  ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails details = new ExceptionDetails(LocalDate.now() , ex.getMessage() , request.getDescription(false));
		
		return new ResponseEntity(details , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(userNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails details = new ExceptionDetails(LocalDate.now() , ex.getMessage() , request.getDescription(false));
		
		return new ResponseEntity(details , HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ExceptionDetails details = new ExceptionDetails(LocalDate.now() , ex.getMessage() , request.getDescription(false));
		return new ResponseEntity(details , HttpStatus.BAD_REQUEST);
	}

}
