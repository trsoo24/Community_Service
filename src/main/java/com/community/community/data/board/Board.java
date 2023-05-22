package com.community.community.data.board;

import com.community.community.data.domain.User;
import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
