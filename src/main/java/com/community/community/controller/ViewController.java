package com.community.community.controller;

import com.community.community.data.board.dto.ViewBoardDto;
import com.community.community.data.board.model.Board;
import com.community.community.service.board.ViewBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/view")
@RestController
public class ViewController {
    private final ViewBoardService viewBoardService;

    @GetMapping("/all")
    public ResponseEntity<Page<ViewBoardDto>> viewAllBoard(Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.viewAllBoard(pageable));
    }

    @GetMapping("/title")
    public ResponseEntity<Page<ViewBoardDto>> searchTitleBoard(@Param("title") @Valid String title, Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.searchTitle(title, pageable));
    }

    @GetMapping("/nickname")
    public ResponseEntity<Page<ViewBoardDto>> searchNickNameBoard(@Param("nickName") @Valid String nickName, Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.searchNickName(nickName, pageable));
    }

    @GetMapping("/detail")
    public ResponseEntity<Board> viewDetailPost(@Param("boardId") @Valid Long boardId) {
        return ResponseEntity.ok(viewBoardService.viewDetail(boardId));
    }
}
