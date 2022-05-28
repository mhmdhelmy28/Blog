package com.example.demo.DTOs;

import com.example.demo.Models.Comment;
import com.example.demo.Models.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private LocalDate creationDate;
    private String userName;
    private List<Comment> comments;

}
