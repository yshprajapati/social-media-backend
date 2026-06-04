package com.yash.mapper;

import com.yash.dto.PostRequestDTO;
import com.yash.dto.PostResponseDTO;
import com.yash.entity.Post;

public class PostMapper {
	public static Post toEntity(PostRequestDTO dto) {
		Post post = new Post();
        post.setContent(dto.getContent());
        post.setImgUrl(dto.getImgUrl());
        return post;
	}
	public static PostResponseDTO toDto(Post post) {
		PostResponseDTO dto = new PostResponseDTO();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setImgUrl(post.getImgUrl());
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
	}
}
