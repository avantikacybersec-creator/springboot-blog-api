package com.avantika.blogapi.controller;

import com.avantika.blogapi.dto.CommentDto;
import com.avantika.blogapi.entity.Comment;
import com.avantika.blogapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public CommentDto addComment(@PathVariable Long postId,
                                 @Valid@RequestBody Comment comment){
        return commentService.addComment(postId,comment);
    }

    @GetMapping("/post/{postId}")
    public List<CommentDto> getCommentsByPostId(@PathVariable Long postId){
        return commentService.getCommentsByPostId(postId);
    }
}