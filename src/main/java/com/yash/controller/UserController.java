package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.PostResponseDTO;
import com.yash.dto.UserLoginDTO;
import com.yash.dto.UserRequestDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.entity.User;
import com.yash.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/create")
	public UserResponseDTO save(@Valid @RequestBody UserRequestDTO user) {
		System.out.println(user);
		return service.save(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/fetch/{id}")
	public UserResponseDTO fetch(@PathVariable Long id) {
		return service.fetch(id);
	}
	
	@PutMapping("/{id}")	
	public UserResponseDTO update(@PathVariable Long id,@Valid @RequestBody UserRequestDTO user) {
		return service.update(id,user);
	}
	
	@PutMapping("/{id}/posts")
	public List<PostResponseDTO> userPosts(@PathVariable Long id){
		return service.userPosts(id);
	}
}
