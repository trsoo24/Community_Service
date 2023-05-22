package com.community.community.data.domain;

import com.community.community.data.board.Board;
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

    /** Todo
     * 이 유저가 작성한 글들이 유저 정보 안에 기입되어야하는지?
     * 한다면 따로 클래스를 빼서 작성해야하는지?
     */
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
