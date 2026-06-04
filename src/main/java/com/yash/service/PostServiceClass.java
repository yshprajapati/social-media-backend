package com.yash.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dto.PostRequestDTO;
import com.yash.dto.PostResponseDTO;
import com.yash.dto.UserRequestDTO;
import com.yash.entity.Post;
import com.yash.entity.User;
import com.yash.exception.PostNotFoundException;
import com.yash.exception.UserNotFoundException;
import com.yash.mapper.PostMapper;
import com.yash.repository.PostRepository;
import com.yash.repository.UserRepository;

@Service
public class PostServiceClass implements IPostService {
	@Autowired
	private PostRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public PostResponseDTO save(PostRequestDTO post, Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found"));
		
		Post entity = PostMapper.toEntity(post);
		entity.setUser(user);
		Post save = repo.save(entity);
		return PostMapper.toDto(save);
	}

	@Override
	public void delete(Long id) {
		Post orElseThrow = repo.findById(id)
				                 .orElseThrow(()-> new PostNotFoundException("User Not Found!"));
		repo.delete(orElseThrow);
	}

	@Override
	public PostResponseDTO fetch(Long id) {
		Post orElseThrow = repo.findById(id)
				                 .orElseThrow(()-> new PostNotFoundException("User Not Found!"));
		return PostMapper.toDto(orElseThrow);
	}

	@Override
	public PostResponseDTO update(Long id, PostRequestDTO post) {
		Post exPost = repo.findById(id)
				                 .orElseThrow(()-> new PostNotFoundException("User Not Found!"));
		
		exPost.setContent(post.getContent());
		exPost.setImgUrl(post.getImgUrl());
		return PostMapper.toDto(repo.save(exPost));
	}

}
