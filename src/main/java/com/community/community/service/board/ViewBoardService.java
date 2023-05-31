package com.community.community.service.board;

import com.community.community.data.board.model.Board;
import com.community.community.data.board.dto.ViewBoardDto;
import com.community.community.exception.WrongApproachException;
import com.community.community.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static com.community.community.exception.ErrorMessage.NOT_EXIST_POST;

@RequiredArgsConstructor
@Service
@Transactional
public class ViewBoardService {
    private final BoardRepository boardRepository;


    public Page<ViewBoardDto> viewAllBoard(Pageable pageable) { // 최신순
        Page<Board> page = boardRepository.findAllDesc(pageable);
        return page.map(ViewBoardDto::from);
    }

    public void viewCount(Long boardId) {
        boardRepository.updateView(boardId);
    }

    public Board viewDetail(Long boardId) {
        Board board = boardRepository.findByBoardId(boardId)
                .orElseThrow(() -> new WrongApproachException(NOT_EXIST_POST));

        viewCount(boardId);

        return board;
    }

    public Page<ViewBoardDto> searchTitle(String title, Pageable pageable) {
        Page<Board> page = boardRepository.findAllByTitleContaining(title, pageable);
        if (page == null) {
            throw new WrongApproachException(NOT_EXIST_POST);
        }

        return page.map(ViewBoardDto::from);
    }

    public Page<ViewBoardDto> searchNickName(String nickName, Pageable pageable) {
        Page<Board> page = boardRepository.findAllByWriterContaining(nickName, pageable);
        if (page == null) {
            throw new WrongApproachException(NOT_EXIST_POST);
        }

        return page.map(ViewBoardDto::from);
    }
}
