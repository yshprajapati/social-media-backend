package com.yash.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserLoginDTO {
	@NotBlank(message = "Enter username!")
	private String userName;
	@NotBlank(message = "Enter password!")
	private String password;
}
