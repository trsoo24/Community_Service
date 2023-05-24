package com.community.community.data.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyBoardDto {
    private Long boardId;
    private Long userId;
    private String title;
    private String text;
}
