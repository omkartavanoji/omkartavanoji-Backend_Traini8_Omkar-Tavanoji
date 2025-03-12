package com.example.trainingcenter.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
 * For Handling Validation Error Messages
 */
@RestControllerAdvice
public class ExceptionHandle {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<String, String>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
	}

}
