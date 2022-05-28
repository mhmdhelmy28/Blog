package com.example.demo.DTOs;
import com.example.demo.Models.Post;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
public class UserDTO {
        private String userName;
        private List<Post> posts;
        private List<Post> bookmarks;
        private List<String> followersIds;
        private List<String> followingIds;
}
