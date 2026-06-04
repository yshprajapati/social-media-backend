package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.PostRequestDTO;
import com.yash.dto.PostResponseDTO;
import com.yash.entity.Post;
import com.yash.entity.User;
import com.yash.service.IPostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private IPostService service;
	
	@PostMapping("/users/{id}")
	public PostResponseDTO save(@Valid @RequestBody PostRequestDTO post, @PathVariable Long id) {
		return service.save(post,id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/{id}")
	public PostResponseDTO fetch(@PathVariable Long id) {
		return service.fetch(id);
	}
	
	@PutMapping("/{id}")	
	public PostResponseDTO update(@PathVariable Long id, @Valid @RequestBody PostRequestDTO post) {
		return service.update(id,post);
	}
}
