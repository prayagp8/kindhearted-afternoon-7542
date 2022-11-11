package com.tj.exception;

import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException extends Exception{
	public GlobalException() {
		// TODO Auto-generated constructor stub
	}
	public GlobalException(String message) {
		super(message);
	}
	
	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyErrorDetails> travelsExceptionHandler(TravelsException te,WebRequest req){
		MyErrorDetails err=new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(te.getMessage());
		err.setDescription(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
