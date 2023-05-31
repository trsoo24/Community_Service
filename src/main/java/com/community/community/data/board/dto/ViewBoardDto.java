package com.community.community.data.board.dto;

import com.community.community.data.board.model.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ViewBoardDto {
    private Long boardId;
    private String title;
    private String nickName;
    private LocalDateTime wroteAt;
    private int viewCount;


    public static ViewBoardDto from(Board board) {
        return ViewBoardDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .nickName(board.getUser().getNickName())
                .wroteAt(board.getModifiedAt())
                .viewCount(board.getViewCount())
                .build();
    }
}
