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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CommentService{

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentDto addComment(Long postId,Comment comment){

        logger.info("Adding comment for postId : {}", postId);

        Post post   = postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not Found"));
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);
        logger.info("Comment saved with id : {}",savedComment.getId());

        return mapToDto(savedComment);
    }

    public List<CommentDto> getCommentsByPostId(Long postId){

        logger.info("Fetching comments for postId : {}", postId);

        List<Comment> comments = commentRepository.findByPostId(postId);
        List<CommentDto> dtos = new ArrayList<>();

        for(Comment comment : comments){

            dtos.add(mapToDto(comment));
        }
        return  dtos;
    }

    private CommentDto mapToDto(Comment comment){

        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());

        return dto;
    }
}