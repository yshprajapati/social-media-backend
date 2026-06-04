package com.yash.mapper;

import com.yash.dto.UserRequestDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.entity.User;

public class UserMapper {
    
	 
	public static  User toEntity(UserRequestDTO userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setBio(userDto.getBio());
		user.setEMail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	public static UserResponseDTO toDto(User user) {
		UserResponseDTO repDto = new UserResponseDTO();
		repDto.setId(user.getId());
		repDto.setUserName(user.getUserName());
		repDto.setBio(user.getBio());
		repDto.setEmail(user.getEMail());
		repDto.setCreatedAt(user.getCreatedAt());
		return repDto;
	}
}
