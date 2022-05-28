package com.example.demo.DTOs.Converter;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Models.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDTO entityToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setBookmarks(user.getBookmarks());
        userDTO.setFollowersIds(user.getFollowersIds());
        userDTO.setFollowingIds(user.getFollowingIds());
        userDTO.setPosts(user.getPosts());
        return userDTO;
    }

    public User dtoToEntity(UserDTO userDTO){
        User user = new User();
        user.setPosts(userDTO.getPosts());
        user.setUserName(userDTO.getUserName());
        user.setBookmarks(userDTO.getBookmarks());
        user.setFollowersIds(userDTO.getFollowingIds());
        user.setFollowingIds(userDTO.getFollowingIds());
        return user;
    }
}
