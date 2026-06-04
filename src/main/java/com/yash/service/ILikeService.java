package com.yash.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.dto.LikeRequestDTO;
import com.yash.dto.LikeResponseDTO;
import com.yash.dto.UserResponseDTO;

public interface ILikeService {
	LikeResponseDTO likePost(@RequestBody LikeRequestDTO dto);
	void unlikePost(Long id);
	Long getLikeCounts(Long postId);
	List<UserResponseDTO> getWhoLiked(Long postId);
}
