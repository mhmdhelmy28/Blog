package com.example.demo.Services;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import com.example.demo.Repositories.PostRepository;
import com.example.demo.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Autowired
    public UserServiceImplementation(UserRepository userRepository, PostRepository postRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findByUserName(userId);
    }

    @Override
    public void followUser(String userId, String followedUserId) {
        User user = userRepository.findByUserName(userId);
        User followedUser = userRepository.findByUserName(followedUserId);
        user.getFollowingIds().add(followedUserId) ;
        followedUser.getFollowersIds().add(userId);
        userRepository.save(user);
        userRepository.save(followedUser);
    }

    @Override
    public void unfollowUser(String userId, String unfollowedUserId) {
        User user = userRepository.findByUserName(userId);
        User unfollowedUser = userRepository.findByUserName(unfollowedUserId);
         user.getFollowingIds().remove(unfollowedUserId) ;
         unfollowedUser.getFollowersIds().remove(userId);
          userRepository.save(user);
          userRepository.save(unfollowedUser);
    }

    @Override
    public void bookmarkPost(String userId, int postId) {
        User user = userRepository.findByUserName(userId);
        Post post = postRepository.findById(postId).get();
        user.getBookmarks().add(post);
        userRepository.save(user);
    }

    @Override
    public void deleteBookmark(String userId, int postId) {
        User user = userRepository.findByUserName(userId);
        Post post = postRepository.findById(postId).get();
        user.getBookmarks().remove(post);
        userRepository.save(user);
    }

}
