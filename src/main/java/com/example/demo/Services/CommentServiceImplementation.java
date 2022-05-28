package com.example.demo.Services;

import com.example.demo.DTOs.CommentDTO;
import com.example.demo.Models.Comment;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import com.example.demo.Repositories.CommentRepository;
import com.example.demo.Repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService{
    final private CommentRepository commentRepository;
    final private PostRepository postRepository;
    @Autowired
    public CommentServiceImplementation(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void addComment(int postId, Comment comment) {
        Post post = postRepository.findById(postId).get();
        post.getComments().add(comment);
        comment.setPost(post);
        postRepository.save(post);
    }

    @Override
    public List<Comment> getComments(int postId) {
        Post posts = postRepository.findById(postId).get();
        return (List<Comment>) posts.getComments();
    }
}
