package com.example.demo.Controllers;

import com.example.demo.DTOs.CommentDTO;
import com.example.demo.DTOs.Converter.CommentConverter;
import com.example.demo.Models.Comment;
import com.example.demo.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;
    private final CommentConverter commentConverter;
    @Autowired
    public CommentController(CommentService commentService, CommentConverter commentConverter){
        this.commentConverter = commentConverter;
        this.commentService = commentService;
    }

    @PostMapping(value = "/posts/{postId}/comments")
    public void addComment(@RequestBody CommentDTO commentDTO, @PathVariable int postId){
        Comment comment = commentConverter.DtoToEntity(commentDTO);
        commentService.addComment(postId,comment);
    }

    @GetMapping(value = "/posts/{postId}/comments")
    public List<Comment> getAllComments(@PathVariable int postId){
        return commentService.getComments(postId);
    }
}
