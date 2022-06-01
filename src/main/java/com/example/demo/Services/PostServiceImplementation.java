package com.example.demo.Services;

import com.example.demo.DTOs.PostDTO;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import com.example.demo.Repositories.PostRepository;
import com.example.demo.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Autowired
    public PostServiceImplementation(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void addPost(Post post, String userId) {
        User user = userRepository.findByUserName(userId);
        user.getPosts().add(post);
        post.setUser(user);
        userRepository.save(user);
    }

    @Override
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post getPost(int postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public List<Post> getFeaturedPosts() {
        return postRepository.findAll();
    }

}
