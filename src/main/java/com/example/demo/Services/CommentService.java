package com.example.demo.Services;

import com.example.demo.DTOs.CommentDTO;
import com.example.demo.Models.Comment;

import java.util.List;

public interface CommentService {
     void addComment( int postId, Comment comment);

     List<Comment> getComments(int postId);
}
