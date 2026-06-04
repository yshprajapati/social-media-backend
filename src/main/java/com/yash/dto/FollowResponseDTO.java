package com.yash.dto;

import java.time.LocalDateTime;

import com.yash.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FollowResponseDTO {
	private Long id;
	private UserResponseDTO follower;
	private UserResponseDTO following;
	private LocalDateTime time;
}
