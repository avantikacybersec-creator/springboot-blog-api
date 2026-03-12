package com.avantika.blogapi.controller;

import com.avantika.blogapi.dto.PostDto;

import com.avantika.blogapi.entity.Post;
import com.avantika.blogapi.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {


    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post){
        return  postService.createPost(post);

    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePost(id);

        return "Post deleted";
    }

    @GetMapping
    public Page<PostDto> getPosts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size){

        return postService.getPosts(page,size);

    }

    @GetMapping("/search")
    public List<PostDto> searchPosts(@RequestParam  String keyword){

        return postService.searchPosts(keyword);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id , @RequestBody Post post){

        return postService.updatePost(id,post);
    }

    @GetMapping("/all")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }


}