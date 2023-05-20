package com.community.community.controller;

import com.community.community.data.board.BoardDto;
import com.community.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.createPost(boardDto));
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modifyPost(@RequestBody BoardDto boardDto) {
        return ResponseEntity.ok(boardService.modifyPost(boardDto));
    }
}
