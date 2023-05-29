package com.community.community.data.comment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteCommentDto {
    private Long commentId;
    private Long userId;
}
