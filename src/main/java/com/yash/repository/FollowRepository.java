package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.Follow;
import com.yash.entity.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {
	List<Follow> findByFollower(User user);
	List<Follow> findByFollowing(User user);
	Long countByFollower(User user);
	Long countByFollowing(User user);
	boolean existsByfollowerIdAndFollowingId(Long followerId, Long followingId);
}
