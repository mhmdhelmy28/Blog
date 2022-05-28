package com.example.demo.DTOs.Converter;

import com.example.demo.DTOs.CommentDTO;
import com.example.demo.DTOs.PostDTO;
import com.example.demo.Models.Comment;
import com.example.demo.Models.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentConverter {
    public Comment DtoToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setUserName(commentDTO.getUserName());
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setCreationDate(commentDTO.getCreationDate());
        return comment;
    }

    public CommentDTO entityToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUserName(comment.getUserName());
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setCreationDate(comment.getCreationDate());
        return commentDTO;
    }

    public List<CommentDTO> entitiesToDTOs(List<Comment> comments){
        return comments.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
