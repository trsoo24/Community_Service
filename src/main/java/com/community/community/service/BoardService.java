package com.community.community.service;

import com.community.community.data.board.Board;
import com.community.community.data.board.CreateBoardDto;
import com.community.community.data.board.ModifyBoardDto;
import com.community.community.data.domain.User;
import com.community.community.exception.WrongApproachException;
import com.community.community.repository.BoardRepository;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.community.community.exception.ErrorMessage.INVALID_USER;
import static com.community.community.exception.ErrorMessage.NOT_EXIST_POST;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    /** Todo
     * 로그인한 유저인지 확인
     * 글쓴이 임을 표시할 수 있는 기능부여
     * Board 안에 해당 글쓴이 정보 기입 (ManyToOne Mapping)
     */
    public Board createPost(CreateBoardDto boardDto) {

        User user = userRepository.findById(boardDto.getUserId())
                .orElseThrow(() -> new WrongApproachException(INVALID_USER));


        return boardRepository.save(Board.builder()
                                        .title(boardDto.getTitle())
                                        .text(boardDto.getText())
                                        .user(user)
                                        .build());
    }

    /** Todo
     * 글을 수정하기 위해서는
     * 1. 해당 유저가 쓴 글인지 체크할 것
     * 2. 한 유저가 똑같은 제목으로 n 개 작성했을 수도 있으니 원하는 글을 수정할 수 있도록 boardId 도 받아야함
     * 3. 글에 작성시간, 수정시간, 삭제시간을 모두 표기할 것인지, LastTime 하나만 작성할 것인지
     */
    public Board modifyPost(ModifyBoardDto boardDto) {
        User user = userRepository.findById(boardDto.getUserId())
                .orElseThrow(() -> new WrongApproachException(INVALID_USER));
        Board board = boardRepository.findByBoardId(boardDto.getBoardId())
                .orElseThrow(() -> new WrongApproachException(NOT_EXIST_POST));

        if (!board.getUser().equals(user)) {
            throw new WrongApproachException(INVALID_USER);
        }

        board.setTitle(boardDto.getTitle());
        board.setText(boardDto.getText());
        return board;
    }

    /**
     * 아무 정보도 기입하지 않고 게시판 조회했을 때
     * board 정보 : 작성자 닉네임, 작성시간, 제목, 내용
     * @return 최근 작성한 순서대로 paging 20 개
     */
    public List<Board> SearchAllBoard () {

        return null;
    }
}
