package com.community.community.service;

import com.community.community.data.board.Board;
import com.community.community.data.board.BoardDto;
import com.community.community.data.domain.User;
import com.community.community.exception.CustomException;
import com.community.community.repository.BoardRepository;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.community.community.exception.ErrorMessage.INVALID_USER;
import static com.community.community.exception.ErrorMessage.NOT_EXIST_POST;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public Board createPost(BoardDto boardDto) {
        /** Todo
         * 로그인한 유저인지 확인
         * 글쓴이 임을 표시할 수 있는 기능부여
         * Board 안에 해당 글쓴이 정보 기입 (ManyToOne Mapping)
          */
        User user = userRepository.findByNickName(boardDto.getNickName())
                .orElseThrow(() -> new CustomException(INVALID_USER));


        return boardRepository.save(Board.builder()
                                        .title(boardDto.getTitle())
                                        .text(boardDto.getText())
                                        .user(user)
                                        .build());
    }

    public Board modifyPost(BoardDto boardDto) {
        User user = userRepository.findByNickName(boardDto.getNickName())
                .orElseThrow(() -> new CustomException(INVALID_USER));
        Board board = boardRepository.findByTitle(boardDto.getTitle())
                .orElseThrow(() -> new CustomException(NOT_EXIST_POST));

        if (!board.getUser().equals(user)) {
            throw new CustomException(INVALID_USER);
        }

        board.setTitle(board.getTitle());
        board.setText(board.getText());
        boardRepository.save(board);
        return board;
    }
}
