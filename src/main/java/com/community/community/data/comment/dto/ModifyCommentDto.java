package com.community.community.data.comment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyCommentDto {
    private Long commentId;
    private Long userId;
    private String comment;
}
