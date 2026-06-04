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

import com.yash.dto.CommentRequestDTO;
import com.yash.dto.CommentResponseDTO;
import com.yash.entity.Comment;
import com.yash.service.ICommentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	private ICommentService service;
	
	@PostMapping
	public CommentResponseDTO save(@Valid @RequestBody CommentRequestDTO cmnt) {
		return service.save(cmnt);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/{id}")
	public CommentResponseDTO fetch(@PathVariable Long id) {
		return service.fetch(id);
	}
	
	@PutMapping("/{id}")	
	public CommentResponseDTO update(@PathVariable Long id,@Valid @RequestBody CommentRequestDTO post) {
		return service.update(id,post);
	}
	
	
}
