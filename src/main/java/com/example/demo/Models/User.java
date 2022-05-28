package com.example.demo.Models;

import com.example.demo.DTOs.UserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_bookmarks",
        joinColumns = @JoinColumn(name = "user_id")
    )
    private List<Post> bookmarks;

    @ElementCollection
    private List<String> followersIds;

    @ElementCollection
    private List<String> followingIds;

    public User(String userId) {
        this.userName = userId;
    }
}
