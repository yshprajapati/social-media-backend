package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dto.FollowRequestDTO;
import com.yash.dto.FollowResponseDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.service.IFollowService;

@RestController
@RequestMapping("/api/follows")
public class FollowController {
	
	@Autowired
	private IFollowService service;
	
	@PostMapping("/follow_user")
	public FollowResponseDTO followUser(@RequestBody FollowRequestDTO dto) {
		return service.followUser(dto);
	}
	
	@PostMapping("/unfollow_user")
	public void unfollowUser(@RequestBody FollowRequestDTO dto) {
		service.unfollowUser(dto);
	}
	
	@GetMapping("/user/{userId}/get_followers")
	public List<UserResponseDTO> getFollowers(@PathVariable Long userId){
		return service.getFollowers(userId);
	}
	
	@GetMapping("/user/{userId}/get_following")
	public List<UserResponseDTO> getFollowing(@PathVariable Long userId){
		return service.getFollowing(userId);
	}
	
	@GetMapping("/user/{userId}/followers/count")
	public Long getFollowersCount(@PathVariable Long userId) {
		return service.getFollowersCount(userId);
	}
	
	@GetMapping("/user/{userId}/following/count")
	public Long getFollowingCount(@PathVariable Long userId) {
		return service.getFollowingCount(userId);
	}
	
}
