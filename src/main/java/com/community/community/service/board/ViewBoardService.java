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

    /**
     * 게시글 목록 조회
     *     - 로그인하지 않은 유저도 게시글 목록 및 게시글 조회 가능 ( 로그인 필요 X )
     *     - 등록되어있는 글들을 최신순 ( 기본 )으로 조회하는 기능
     *     - 필요에 따라 댓글 많은 순, 댓글 적은 순으로 정렬 기능
     *     - 페이징을 통해 20개씩 조회가 가능하도록 구현
     */

    public Page<ViewBoardDto> ViewAllBoard(Pageable pageable) { // 최신순
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
