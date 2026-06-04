package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.entity.User;
import com.yash.exception.UserNotFoundException;
import com.yash.repository.UserRepository;

@Service
public class CustomizeUserDetailsService  implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username).orElseThrow(()-> new UserNotFoundException("Invalid Credentials!"));
		return org.springframework.security.core.userdetails.User
				.builder()
				.username(user.getUserName())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}

}
