package com.yash.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dto.FollowRequestDTO;
import com.yash.dto.FollowResponseDTO;
import com.yash.dto.UserResponseDTO;
import com.yash.entity.Follow;
import com.yash.entity.User;
import com.yash.exception.UserNotFoundException;
import com.yash.mapper.FollowMapper;
import com.yash.mapper.UserMapper;
import com.yash.repository.FollowRepository;
import com.yash.repository.UserRepository;

@Service
public class FollowService implements IFollowService {
	
	@Autowired
	private FollowRepository followRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public FollowResponseDTO followUser(FollowRequestDTO dto) {
		User follower = userRepo.findById(dto.getFollowerId()).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		User following = userRepo.findById(dto.getFollowingId()).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
        
		if(follower.getId().equals(following.getId())) {
        	throw new RuntimeException("Users can't follow themselves");
        }
		
		if(followRepo.existsByfollowerIdAndFollowingId(follower.getId(), following.getId())) {
        	throw new RuntimeException("User already Follows");
        }
		Follow entity = FollowMapper.toEntity(follower, following);
		return FollowMapper.toDTO(followRepo.save(entity));
	}

	@Override
	public void unfollowUser(FollowRequestDTO dto) {
		User follower = userRepo.findById(dto.getFollowerId()).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		User following = userRepo.findById(dto.getFollowingId()).orElseThrow(()->new UserNotFoundException("User Not Found!!"));

		Follow entity = FollowMapper.toEntity(follower, following);
		followRepo.delete(entity);
	}

	@Override
	public List<UserResponseDTO> getFollowers(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		List<Follow> following = followRepo.findByFollowing(user);
		List<UserResponseDTO> collect = following.stream()
				                                   .map(follow-> UserMapper.toDto(follow.getFollower()))
				                                     .collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<UserResponseDTO> getFollowing(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		List<Follow> follower = followRepo.findByFollower(user);
		List<UserResponseDTO> collect = follower.stream()
				                                   .map(follow-> UserMapper.toDto(follow.getFollowing()))
				                                     .collect(Collectors.toList());
		return collect;
	}

	@Override
	public Long getFollowersCount(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		Long follower = followRepo.countByFollowing(user);
		return follower;
	}

	@Override
	public Long getFollowingCount(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found!!"));
		Long following = followRepo.countByFollower(user);
		return following;
	}

}
