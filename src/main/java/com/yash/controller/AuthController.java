package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.UserLoginDTO;
import com.yash.dto.UserLoginResponseDTO;
import com.yash.dto.UserRequestDTO;
import com.yash.service.IUserService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserRequestDTO dto)
	{
		service.save(dto);
		return ResponseEntity.ok("User Registered Successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDTO> loginUser(@RequestBody UserLoginDTO dto)
	{
		
		return service.userLogin(dto);
	}
}
