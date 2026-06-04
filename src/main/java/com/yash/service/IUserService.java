package com.yash.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.yash.dto.PostResponseDTO;
import com.yash.dto.UserLoginDTO;
import com.yash.dto.UserLoginResponseDTO;
import com.yash.dto.UserRequestDTO;
import com.yash.dto.UserResponseDTO;


public interface IUserService {
	public UserResponseDTO save(UserRequestDTO user);
	public ResponseEntity<UserLoginResponseDTO> userLogin(UserLoginDTO dto);
	public UserResponseDTO update(Long id, UserRequestDTO user);
	public void delete(Long id);
	public UserResponseDTO fetch(Long id);
	public List<PostResponseDTO> userPosts(Long id);
}
