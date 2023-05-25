package com.community.community.data.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteBoardDto {
    private Long boardId;
    private Long userId;
}
