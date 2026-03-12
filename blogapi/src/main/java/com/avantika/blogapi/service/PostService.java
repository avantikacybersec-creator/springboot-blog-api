package com.avantika.blogapi.service;


import com.avantika.blogapi.dto.PostDto;
import com.avantika.blogapi.entity.Post;
import com.avantika.blogapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post  createPost(Post post){
        return postRepository.save(post);
    }


    public List<PostDto> getAllPosts(){

        List<Post> posts = postRepository.findAll();


        return posts.stream()
                .map(this::convertToDto)
                .toList();


    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public PostDto convertToDto(Post post){

        PostDto dto = new PostDto();

        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());

        return dto;
    }

    public Page<PostDto> getPosts(int page , int size){

        Pageable pageable = PageRequest.of(page, size);

        Page<Post> posts = postRepository.findAll(pageable);

        return  posts.map(this::convertToDto);

    }


    public List<PostDto> searchPosts(String keyword) {
        List<Post> posts = postRepository.findByTitleContaining(keyword);

        return posts.stream()
                .map(this::convertToDto)
                .toList();

    }


    public Post updatePost(Long id , Post updatedPost){

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());

        return postRepository.save(post);
    }


    public List<PostDto> getAllPostsDto(){

        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(this::convertToDto)
                .toList();
    }
}