package com.example.demo.Controllers;

import com.example.demo.DTOs.Converter.PostConverter;
import com.example.demo.DTOs.PostDTO;
import com.example.demo.Models.Post;
import com.example.demo.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PostController {
    private PostService postService;
    private PostConverter postConverter;
    @Autowired
    public PostController(PostService postService, PostConverter postConverter){
        this.postConverter = postConverter;
        this.postService = postService;
    }

    @PostMapping(value = "/users/{userId}/posts/post")
    public void addPost(@PathVariable String userId, @RequestBody PostDTO postDTO){
        Post post = postConverter.DtoToEntity(postDTO);
        postService.addPost(post,userId);
    }

    @GetMapping(value = "/posts/{postId}/get")
    public PostDTO getPost(@PathVariable int postId){
       return postConverter.entityToDTO(postService.getPost(postId));
    }

    @GetMapping(value = "posts/get")
    public List<PostDTO> getAllPosts(){
        return postConverter.entitiesToDTOs(postService.getFeaturedPosts());
    }
}
