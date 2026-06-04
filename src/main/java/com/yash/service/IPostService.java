package com.yash.service;

import javax.xml.stream.events.Comment;

import com.yash.dto.PostRequestDTO;
import com.yash.dto.PostResponseDTO;


public interface IPostService {
	public PostResponseDTO save(PostRequestDTO post, Long userId);
	public void delete(Long id);
	public PostResponseDTO fetch(Long Id);
	public PostResponseDTO update(Long id, PostRequestDTO post);
}
