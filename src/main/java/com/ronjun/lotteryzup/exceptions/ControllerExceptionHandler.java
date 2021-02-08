package com.ronjun.lotteryzup.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(InvalidBetException.class)
	public ResponseEntity<StandardError> database(InvalidBetException e , HttpServletRequest request){
		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setMessage(e.getMessage());
		err.setError("Invalid Bet exception");
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
