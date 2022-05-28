package com.example.demo.Services;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;

import java.util.List;

public interface UserService {
     void addUser(User user);

     void removeUser(User user);

     User getUser(String userId);

     void followUser(String userId, String followedUserId);

     void unfollowUser(String userId, String unfollowedUserId);

     void bookmarkPost(String userId, int postId);

     void deleteBookmark(String userId, int postId);
}
