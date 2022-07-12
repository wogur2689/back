package com.hyeok.back.board.repository;

import com.hyeok.back.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Query(name = "board.heartCountUp")
    static boolean heartCountUp(@Param("boardId") Long id) {
        return true;
    }; //좋아요 증가

    @Query(name = "board.heartCountDown")
    static boolean heartCountDown(@Param("boardID") Long id) {
        return true;
    }; //좋아요 감소
}
