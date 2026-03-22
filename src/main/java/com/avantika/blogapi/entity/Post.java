package com.avantika.blogapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Content cannot be empty")
    @Column(length = 5000)
    private String content;
    private LocalDateTime createdAt;

    private String author;


    @ManyToOne
    @JoinColumn(name="user_id")
    private  User user;

    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;
}
