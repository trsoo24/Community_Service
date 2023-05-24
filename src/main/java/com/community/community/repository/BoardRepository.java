package com.community.community.repository;


import com.community.community.data.board.Board;
import com.community.community.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByBoardId(Long boardId);
    Optional<Board> findByTitle(String title);
    List<Board> findAllByUserId(Long userId);
}
