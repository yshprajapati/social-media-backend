package com.yash.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dto.LikeRequestDTO;
import com.yash.dto.LikeResponseDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.entity.Like;
import com.yash.entity.Post;
import com.yash.entity.User;
import com.yash.exception.LikeNotFoundException;
import com.yash.exception.PostNotFoundException;
import com.yash.exception.UserNotFoundException;
import com.yash.mapper.LikeMapper;
import com.yash.mapper.UserMapper;
import com.yash.repository.LikeRepository;
import com.yash.repository.PostRepository;
import com.yash.repository.UserRepository;

@Service
public class LikeService implements ILikeService {

	@Autowired
	private LikeRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public LikeResponseDTO likePost(LikeRequestDTO dto) {
		User user = userRepo.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
	    Post post = postRepo.findById(dto.getPostId()).orElseThrow(()->new PostNotFoundException("Post Not Found!!"));
		Like like = LikeMapper.toEntity(user, post);
	    return LikeMapper.toDTO(repo.save(like));	
	}

	@Override
	public void unlikePost(Long id) {
		Like like = repo.findById(id).orElseThrow(()->new LikeNotFoundException("Like Not Found!"));
		repo.delete(like);
	}

	@Override
	public Long getLikeCounts(Long postId) {
		Post post = postRepo.findById(postId).orElseThrow(()->new PostNotFoundException("Post Not Found!"));
		Long countByPost = repo.countByPost(post);
		return countByPost;
	}

	@Override
	public List<UserResponseDTO> getWhoLiked(Long postId) {
		Post post = postRepo.findById(postId).orElseThrow(()-> new PostNotFoundException("Post Not Found!!"));
		List<Like> byPost = repo.findByPost(post);
		List<UserResponseDTO> collect = byPost.stream()
				                                .map(like -> UserMapper.toDto(like.getUser()))
				                                  .collect(Collectors.toList());
		return collect;
	}
}
