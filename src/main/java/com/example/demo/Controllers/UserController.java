package com.example.demo.Controllers;

import com.example.demo.DTOs.Converter.UserConverter;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {
    private UserService userService;
    private UserConverter userConverter;
    @Autowired
    public UserController(UserService userService, UserConverter userConverter){
        this.userConverter = userConverter;
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void addUser(@RequestBody UserDTO userDTO){
        User user = userConverter.dtoToEntity(userDTO);
        userService.addUser(user);
    }

    @GetMapping(value = "/user/{userId}")
    public UserDTO getUser(@PathVariable String userId){
       return userConverter.entityToDTO(userService.getUser(userId));
    }

    @PostMapping("/users/{userId}/posts/{postId}/bookmark")
    public void bookmarkPost(@PathVariable String userId, @PathVariable int postId){
        userService.bookmarkPost(userId,postId);
    }

    @PutMapping("/users/{userId}/follow/{followedUserId}")
    public void followUser(@PathVariable String userId, @PathVariable String followedUserId){
        userService.followUser(userId,followedUserId);
    }

    @PutMapping("/users/{userId}/unfollow/{unfollowedUser}")
    public void unfollowUser(@PathVariable String userId, @PathVariable String unfollowedUser){
        userService.unfollowUser(userId,unfollowedUser);
    }

    @DeleteMapping("/users/{userId}/posts/{postId}/unBookmark")
    public void deleteBookmark(@PathVariable String userId, @PathVariable int postId){
        userService.deleteBookmark(userId,postId);
    }

}
