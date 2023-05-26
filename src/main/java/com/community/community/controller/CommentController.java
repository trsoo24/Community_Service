package com.community.community.controller;

import com.community.community.data.comment.dto.CreateCommentDto;
import com.community.community.data.comment.model.Comment;
import com.community.community.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody @Valid CreateCommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }
}
