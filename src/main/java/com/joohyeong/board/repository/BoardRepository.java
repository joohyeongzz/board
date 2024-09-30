package com.joohyeong.board.repository;

import com.joohyeong.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.view = b.view + 1 where b.boardId = :boardId")
    void incrementViewCount(long boardId);

    void deleteByBoardId(long boardId);

    void updateBoardByBoardId(long boardId);



}
