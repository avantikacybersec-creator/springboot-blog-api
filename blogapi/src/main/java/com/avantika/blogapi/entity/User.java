package com.avantika.blogapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String role ;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;






}
