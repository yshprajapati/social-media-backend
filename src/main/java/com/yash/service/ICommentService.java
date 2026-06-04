package com.yash.service;

import com.yash.dto.CommentRequestDTO;
import com.yash.dto.CommentResponseDTO;


public interface ICommentService 
{
	public CommentResponseDTO save(CommentRequestDTO cmnt);
	public void delete(Long id);
	public CommentResponseDTO fetch(Long Id);
	public CommentResponseDTO update(Long id, CommentRequestDTO cmnt);
	
}
