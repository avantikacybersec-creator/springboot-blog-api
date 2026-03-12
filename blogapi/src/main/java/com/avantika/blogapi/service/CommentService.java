package com.avantika.blogapi.service;


import com.avantika.blogapi.dto.CommentDto;
import com.avantika.blogapi.entity.Comment;
import com.avantika.blogapi.entity.Post;
import com.avantika.blogapi.exception.ResourceNotFoundException;
import com.avantika.blogapi.repository.CommentRepository;
import com.avantika.blogapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentDto addComment(Long postId,Comment comment){

        Post post   =postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not Found"));
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setContent(savedComment.getContent());
        return dto;
    }

    public List<CommentDto> getCommentsByPostId(Long postId){

        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentDto> dtos = new ArrayList<>();

        for(Comment comment : comments){
            CommentDto dto =new CommentDto();
            dto.setId(comment.getId());
            dto.setContent(comment.getContent());
            dtos.add(dto);
        }
        return  dtos;
    }
}