package com.yash.service;

import java.util.Optional;

import com.yash.dto.CommentRequestDTO;
import com.yash.dto.CommentResponseDTO;
import com.yash.entity.Comment;
import com.yash.exception.CommentNotFoundException;
import com.yash.mapper.CommentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.repository.CommentRepository;

@Service
public class CommentServiceClass implements ICommentService {

	@Autowired
	private CommentRepository repo;

	@Override
	public CommentResponseDTO save(CommentRequestDTO cmnt) {
		return CommentMapper.toDTO(repo.save(CommentMapper.toEntity(cmnt)));
	}

	@Override
	public void delete(Long id) {
		Comment comment = repo.findById(id)
			      .orElseThrow(()->new CommentNotFoundException("Comment Not Found!"));
			repo.delete(comment);
	}

	@Override
	public CommentResponseDTO fetch(Long id) {
		Comment comment = repo.findById(id)
		      .orElseThrow(()->new CommentNotFoundException("Comment Not Found!"));
	
		return CommentMapper.toDTO(comment);
	}

	@Override
	public CommentResponseDTO update(Long id, CommentRequestDTO cmnt) {
		Comment comment = repo.findById(id)
			      .orElseThrow(()->new CommentNotFoundException("Comment Not Found!"));
		
		comment.setText(cmnt.getText());
		return CommentMapper.toDTO(repo.save(comment));
	}
}