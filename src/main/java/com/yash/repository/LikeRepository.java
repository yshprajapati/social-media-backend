package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.Like;
import com.yash.entity.Post;


public interface LikeRepository extends JpaRepository<Like, Long>{
	Long countByPost(Post post);
	List<Like> findByPost(Post post);

}
