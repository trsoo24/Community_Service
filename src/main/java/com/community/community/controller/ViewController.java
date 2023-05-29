package com.community.community.controller;

import com.community.community.data.board.dto.ViewBoardDto;
import com.community.community.data.board.model.Board;
import com.community.community.service.ViewBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/view")
@RestController
public class ViewController {
    private final ViewBoardService viewBoardService;

    @GetMapping("/all")
    public ResponseEntity<Page<ViewBoardDto>> viewAllBoard(Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.ViewAllBoard(pageable));
    }

    @GetMapping("/title")
    public ResponseEntity<Page<ViewBoardDto>> searchTitleBoard(String text, Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.searchTitle(text, pageable));
    }

    @GetMapping("/nickname")
    public ResponseEntity<Page<ViewBoardDto>> searchNickNameBoard(String text, Pageable pageable) {
        return ResponseEntity.ok(viewBoardService.searchNickName(text, pageable));
    }

    @GetMapping("/detail")
    public ResponseEntity<Board> viewDetailPost(Long boardId) {
        return ResponseEntity.ok(viewBoardService.viewDetail(boardId));
    }

}
