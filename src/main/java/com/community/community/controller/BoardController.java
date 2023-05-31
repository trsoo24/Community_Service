package com.community.community.controller;

import com.community.community.data.board.model.Board;
import com.community.community.data.board.dto.CreateBoardDto;
import com.community.community.data.board.dto.DeleteBoardDto;
import com.community.community.data.board.dto.ModifyBoardDto;
import com.community.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Board> createPost(@RequestBody @Valid CreateBoardDto boardDto) {
        return ResponseEntity.ok(boardService.createPost(boardDto));
    }

    @PutMapping("/modify")
    public ResponseEntity<Board> modifyPost(@RequestBody @Valid ModifyBoardDto boardDto) {
        return ResponseEntity.ok(boardService.modifyPost(boardDto));
    }

    @PutMapping("/delete")
    public String deletePost(@RequestBody @Valid DeleteBoardDto boardDto) {
        boardService.deletePost(boardDto);
        LocalDateTime date = LocalDateTime.now();
        date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


        return "게시물이 삭제되었습니다. " + date;
    }
}
