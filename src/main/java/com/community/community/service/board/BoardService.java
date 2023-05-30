package com.community.community.service.board;

import com.community.community.data.board.dto.CreateBoardDto;
import com.community.community.data.board.dto.DeleteBoardDto;
import com.community.community.data.board.dto.ModifyBoardDto;
import com.community.community.data.board.model.Board;
import com.community.community.data.user.model.User;
import com.community.community.exception.WrongApproachException;
import com.community.community.repository.BoardRepository;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.community.community.exception.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;


    public Board createPost(CreateBoardDto boardDto) {

        User user = userRepository.findById(boardDto.getUserId())
                .orElseThrow(() -> new WrongApproachException(INVALID_USER));


        Board board = boardRepository.save(Board.builder()
                                        .title(boardDto.getTitle())
                                        .text(boardDto.getText())
                                        .writer(user.getNickName())
                                        .user(user)
                                        .build());
        user.addBoard(board);
        return board;
    }

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

    public void deletePost(DeleteBoardDto boardDto) {
        User user = userRepository.findById(boardDto.getUserId())
                .orElseThrow(() -> new WrongApproachException(INVALID_USER));
        Board board = boardRepository.findByBoardId(boardDto.getBoardId())
                .orElseThrow(() -> new WrongApproachException(NOT_EXIST_POST));

        board.setTitle("이미 삭제된 게시글입니다.");
        board.setText(LocalDateTime.now().toString());
    }

}
