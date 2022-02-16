package com.pang.project.week1.board;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.dto.BoardResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b ORDER BY b.modifiedAt DESC")
    List<Board> findAllDesc();

}
