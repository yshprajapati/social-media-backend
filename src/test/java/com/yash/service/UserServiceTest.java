package com.yash.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import com.yash.dto.UserResponseDTO;
import com.yash.entity.User;
import com.yash.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository repo;
	
	@InjectMocks
	private UserServiceClass service;
	
	@Test
	void testSaveUser() {
		
		User user =  new User();
		user.setUserName("Yash");
		user.setId(1L);
		
		when(repo.findById(1L)).thenReturn(Optional.of(user));
		
		User savedUser = repo.save(user);
		
		UserResponseDTO fetch = service.fetch(1L);
		assertEquals("Yash", fetch.getUserName());
		
	}
}
