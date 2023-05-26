package com.community.community.data.comment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCommentDto {
    private String comment;
    private Long userId;
    private Long boardId;
}
