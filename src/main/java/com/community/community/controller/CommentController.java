package com.community.community.controller;

import com.community.community.data.comment.dto.CreateCommentDto;
import com.community.community.data.comment.dto.DeleteCommentDto;
import com.community.community.data.comment.dto.ModifyCommentDto;
import com.community.community.data.comment.model.Comment;
import com.community.community.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody @Valid CreateCommentDto commentDto) {
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }

    @PutMapping("/modify")
    public ResponseEntity<Comment> modifyComment(@RequestBody @Valid ModifyCommentDto commentDto) {
        return ResponseEntity.ok(commentService.modifyComment(commentDto));
    }

    @PutMapping("/delete")
    public String deleteComment(@RequestBody @Valid DeleteCommentDto commentDto) {
        commentService.deleteComment(commentDto);
        LocalDateTime date = LocalDateTime.now();
        date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return "댓글이 삭제되었습니다. " + date;
    }
}
