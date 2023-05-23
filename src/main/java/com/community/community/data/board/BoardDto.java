package com.community.community.data.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private String nickName;
    private String title;
    private String text;
}
