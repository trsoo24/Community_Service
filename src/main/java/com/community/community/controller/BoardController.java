package com.community.community.controller;

import com.community.community.data.board.Board;
import com.community.community.data.board.CreateBoardDto;
import com.community.community.data.board.ModifyBoardDto;
import com.community.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Board> createPost(@RequestBody @Valid CreateBoardDto boardDto) {
        return ResponseEntity.ok(boardService.createPost(boardDto));
    }

    @PostMapping("/modify")
    public ResponseEntity<Board> modifyPost(@RequestBody @Valid ModifyBoardDto boardDto) {
        return ResponseEntity.ok(boardService.modifyPost(boardDto));
    }
}
