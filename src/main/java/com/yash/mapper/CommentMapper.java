package com.yash.mapper;

import com.yash.dto.CommentRequestDTO;
import com.yash.dto.CommentResponseDTO;
import com.yash.entity.Comment;

public class CommentMapper {

    public static Comment toEntity(CommentRequestDTO dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());
        return comment;
    }

    public static CommentResponseDTO toDTO(Comment comment) {

        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setCreatedAt(comment.getCreatedAt());

        return dto;
    }
}