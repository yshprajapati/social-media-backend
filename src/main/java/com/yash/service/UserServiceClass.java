package com.yash.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.dto.PostResponseDTO;
import com.yash.dto.UserLoginDTO;
import com.yash.dto.UserLoginResponseDTO;
import com.yash.dto.UserRequestDTO;
import com.yash.dto.UserResponseDTO;

import com.yash.entity.User;
import com.yash.exception.UserNotFoundException;
import com.yash.mapper.PostMapper;
import com.yash.mapper.UserMapper;
import com.yash.repository.UserRepository;

@Service
public class UserServiceClass implements IUserService {
    
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	public UserResponseDTO save(UserRequestDTO userDto) {
		User entity = UserMapper.toEntity(userDto);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		User saved = repo.save(entity);
		return UserMapper.toDto(saved);
	}
	
	@Override
	public ResponseEntity<UserLoginResponseDTO> userLogin(UserLoginDTO dto)
	{
		Authentication authenticate = authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
		
		String token = jwtService.generateToken(dto.getUserName());
		UserLoginResponseDTO response = new UserLoginResponseDTO(token, "User Logged in Successfully");
		return ResponseEntity.ok(response);
	}
	
	
	@Override
	public UserResponseDTO update(Long id, UserRequestDTO updateUser) {
		User existingUser = repo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found!"));
		
		existingUser.setUserName(updateUser.getUserName());
		existingUser.setBio(updateUser.getBio());
		existingUser.setEMail(updateUser.getEmail());
		existingUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
		return UserMapper.toDto(repo.save(existingUser));
	}
	

	@Override
	public void delete(Long id) {
		User existingUser = repo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found!"));
			
			repo.delete(existingUser);
	}

	@Override
	public UserResponseDTO fetch(Long id) {
		User existingUser = repo.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found!"));
		return UserMapper.toDto(existingUser);
	}

	@Override
	public List<PostResponseDTO> userPosts(Long id) {
		User existingUser = repo.findById(id)
				                  .orElseThrow(()->new UserNotFoundException("User Not Found!"));
		
		 List<PostResponseDTO> collect = existingUser.getPosts()
				                                      .stream() 
				                                       .filter(Objects::nonNull)
				                                        .map(PostMapper::toDto)
				                                         .collect(Collectors.toList());
		return collect;
	}
	
}
