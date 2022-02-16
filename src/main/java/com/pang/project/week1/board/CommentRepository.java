package com.pang.project.week1.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.board.id = :boardId ORDER BY c.modifiedAt DESC")
    List<Comment> findAllDesc(@Param("boardId") Long boardId);

    Optional<Comment> findByCommentId(Long commentId);

}

