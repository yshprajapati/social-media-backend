package com.yash.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(UserNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public String handlePostNotFoundException(PostNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(CommentNotFoundException.class)
	public String handleCommentNotFoundException(CommentNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException ex)
	{
		return ex.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex)
	{
		String error = ex.getBindingResult().getFieldError().getDefaultMessage();
		
		return ResponseEntity.badRequest().body(error);
	}
}
