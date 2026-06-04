package com.yash.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UserRequestDTO {
	@NotBlank(message = "Username is required!")
	private String userName;
	@Email
    private String email;
    private String bio;
    @NotBlank(message = "Password is required!")
	private String password;
}
