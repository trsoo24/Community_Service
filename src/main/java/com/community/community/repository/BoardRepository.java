package com.community.community.repository;


import com.community.community.data.board.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByBoardId(Long boardId);
    @Modifying
    @Query("update Board set viewCount = viewCount + 1 where boardId = :boardId")
    void updateView(Long boardId);

    Page<Board> findAllByTitleContaining(String word, Pageable pageable);
    Page<Board> findAllByUserContaining(String nickName, Pageable pageable);
}
