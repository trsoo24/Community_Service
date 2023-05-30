package com.community.community.service.comment;


import com.community.community.data.board.model.Board;
import com.community.community.data.comment.dto.CreateCommentDto;
import com.community.community.data.comment.model.Comment;
import com.community.community.data.user.model.User;
import com.community.community.exception.WrongApproachException;
import com.community.community.repository.BoardRepository;
import com.community.community.repository.CommentRepository;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.community.community.exception.ErrorMessage.NOT_EXIST_POST;
import static com.community.community.exception.ErrorMessage.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public Comment createComment(CreateCommentDto commentDto) {
        User user = userRepository.findById(commentDto.getUserId())
                .orElseThrow(() -> new WrongApproachException(USER_NOT_FOUND));

        Board board = boardRepository.findByBoardId(commentDto.getBoardId())
                .orElseThrow(() -> new WrongApproachException(NOT_EXIST_POST));

        Comment comment = commentRepository.save(Comment.builder()
                        .text(commentDto.getComment())
                        .writer(user.getNickName())
                        .user(user)
                        .board(board)
                        .build());

        board.addComment(comment);
        return comment;
    }
}
