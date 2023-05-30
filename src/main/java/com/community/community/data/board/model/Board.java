package com.community.community.data.board.model;

import com.community.community.data.TimeEntity;
import com.community.community.data.comment.model.Comment;
import com.community.community.data.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private String writer;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    @OrderBy("commentId") // 댓글 정렬
    private List<Comment> commentList;

    public void addComment(Comment comment) {
        this.commentList.add(comment);
        comment.setBoard(this);
    }

}
