package com.example.demo.DTOs.Converter;

import com.example.demo.DTOs.PostDTO;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PostConverter {
    public Post DtoToEntity(PostDTO postDTO){
        Post post = new Post();
        post.setUser(new User(postDTO.getUserName()));
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setCreationDate(postDTO.getCreationDate());
        return post;
    }

    public PostDTO entityToDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setUserName(post.getUser().getUserName());
        postDTO.setId(post.getId());
        postDTO.setContent(post.getContent());
        postDTO.setTitle(post.getTitle());
        postDTO.setCreationDate(post.getCreationDate());
        return postDTO;
    }



    public List<PostDTO> entitiesToDTOs(List<Post> posts){
       return posts.stream().map(this::entityToDTO).collect(Collectors.toList());
    }
}
