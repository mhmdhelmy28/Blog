package com.example.demo.DTOs;

import com.example.demo.Models.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDTO {
    private int id;
    private String content;
    private LocalDate creationDate;
    private String userName;
}
