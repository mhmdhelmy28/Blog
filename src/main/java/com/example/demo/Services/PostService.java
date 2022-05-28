package com.example.demo.Services;

import com.example.demo.DTOs.PostDTO;
import com.example.demo.Models.Post;

import java.util.List;


public interface PostService {
     void addPost(Post post, String userId);

     void deletePost(int postId);

     Post getPost(int postId);

     List<Post> getFeaturedPosts();



}
