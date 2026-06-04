package com.yash.dto;

import java.time.LocalDateTime;

import com.yash.entity.Post;
import com.yash.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class LikeResponseDTO {
	 private Long id;
	 private UserResponseDTO userDto;
	 private PostResponseDTO postDto;
	 private LocalDateTime likedAt;
}
