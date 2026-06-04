package com.yash.mapper;




import com.yash.dto.LikeResponseDTO;

import com.yash.entity.Like;
import com.yash.entity.Post;
import com.yash.entity.User;

public class LikeMapper {

    public static Like toEntity(User user,  Post post) {
    	Like like = new Like();
    	like.setUser(user);
    	like.setPost(post);
    	return like;
    }

    public static LikeResponseDTO toDTO(Like like) {

    	LikeResponseDTO dto = new LikeResponseDTO();
        dto.setId(like.getId());
        dto.setUserDto(UserMapper.toDto(like.getUser()));
        dto.setPostDto(PostMapper.toDto(like.getPost()));
        dto.setLikedAt(like.getDate());
        return dto;
    }
}