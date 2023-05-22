package com.community.community.data.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBoardDto {
    private Long userId;
    private String title;
    private String text;
}
