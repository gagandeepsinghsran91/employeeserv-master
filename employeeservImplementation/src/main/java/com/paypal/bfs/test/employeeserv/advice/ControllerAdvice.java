package com.paypal.bfs.test.employeeserv.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);
	
	private static final String INTERNAL_SERVER_ERROR= "INTERNAL_SERVER_ERROR";
	
	private static final String REQUEST_VALIDATION_FAILED_DUE_TO_FIELD= "REQUEST_VALIDATION_FAILED_DUE_TO_FIELD  ";
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
    public final ResponseEntity<Object> handleAllException(Exception ex){
		
		log.error("There was an error processing the request", ex);
 		
		return new ResponseEntity<>(INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		/*
		 * I am trying to avoid over Engineering, I hope this suffice for now
		 */
       if(ex.getBindingResult()!=null) {
    	   ex.getBindingResult().getFieldError().getField();
		return  new ResponseEntity<>(REQUEST_VALIDATION_FAILED_DUE_TO_FIELD +ex.getBindingResult().getFieldError().getField(),status);
       }
       return  new ResponseEntity<>(HttpStatus.BAD_REQUEST,status);
	}
	

}
