package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.LikeRequestDTO;
import com.yash.dto.LikeResponseDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.service.ILikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {
	
	@Autowired
	private  ILikeService service;
	
	
	@PostMapping("/like")
	public LikeResponseDTO likePost(@RequestBody LikeRequestDTO dto) {
		return service.likePost(dto);
	}
	
	@DeleteMapping("/unlike/{id}")
	public void unlikePost(@PathVariable Long id) {
		service.unlikePost(id);
	}
	
	@GetMapping("/post/{postId}/count")
	public Long getLikeCounts(@PathVariable Long postId) {
		return service.getLikeCounts(postId);
	}
	
	@GetMapping("/post/{postId}/likedBy")
	public List<UserResponseDTO> getWhoLiked(@PathVariable Long postId){
		return service.getWhoLiked(postId);
	}
}
