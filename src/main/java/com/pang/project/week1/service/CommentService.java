package com.pang.project.week1.service;

import com.pang.project.week1.board.Comment;
import com.pang.project.week1.board.CommentRepository;
import com.pang.project.week1.commentDto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public void update(Long commentId, CommentUpdateDto dto){
        log.info(String.valueOf(commentId));
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글 없음 (id) = " + commentId)
        );
        log.info("코멘트가 null 이다.");
        log.info(String.valueOf(comment));
        comment.update(dto);
    }

}
