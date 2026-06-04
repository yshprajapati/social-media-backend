package com.yash.exception;

public class FollowNotFoundException extends RuntimeException{
	public FollowNotFoundException(String msg) {
		super(msg);
	}
}