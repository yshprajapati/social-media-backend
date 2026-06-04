package com.yash.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.dto.FollowRequestDTO;
import com.yash.dto.FollowResponseDTO;
import com.yash.dto.UserResponseDTO;

public interface IFollowService {

	FollowResponseDTO followUser(FollowRequestDTO dto);
	void unfollowUser(FollowRequestDTO dto);
	List<UserResponseDTO> getFollowers(Long userId);
	List<UserResponseDTO> getFollowing(Long userId);
	Long getFollowersCount(Long userId);
	Long getFollowingCount(Long userId);
}
