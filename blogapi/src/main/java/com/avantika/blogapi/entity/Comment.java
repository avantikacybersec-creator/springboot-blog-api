package com.avantika.blogapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
public class Comment {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message =  "Comment content cannot be empty")
    @Size(min = 2 ,message = "Comment must be at least 2 characters")
    private String content;
    public Comment(){}

    @ManyToOne
    @JoinColumn(name ="post_id")
    @JsonBackReference
    private Post post;


    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }




}
