package com.community.community.data.domain;

import com.community.community.data.board.Board;
import com.community.community.data.board.BoardDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String nickName;
    private String token; // jwt 토큰

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    public void addBoard(Board board) {
        this.boardList.add(board);
        board.setUser(this);
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}
