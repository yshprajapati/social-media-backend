package com.yash.exception;

import lombok.AllArgsConstructor;


public class CommentNotFoundException extends RuntimeException{
	public CommentNotFoundException(String msg) {
		super(msg);
	}
}
