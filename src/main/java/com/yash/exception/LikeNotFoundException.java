package com.yash.exception;

public class LikeNotFoundException extends RuntimeException{
	public LikeNotFoundException(String msg) {
		super(msg);
	}
}