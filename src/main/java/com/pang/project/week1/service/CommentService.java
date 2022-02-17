package com.pang.project.week1.service;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.board.BoardRepository;
import com.pang.project.week1.board.Comment;
import com.pang.project.week1.board.CommentRepository;
import com.pang.project.week1.commentDto.CommentSaveRequestDto;
import com.pang.project.week1.commentDto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 생성
    @Transactional
    public void createComment(Long id, CommentSaveRequestDto dto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글 없음")
        );
        Comment comment = new Comment(dto);
        comment.addBoard(board);
        commentRepository.save(comment);
    }

    // 조회
    @Transactional
    public List<Comment> getAll(Long boardId){
        return commentRepository.findAllDesc(boardId);
    }

    @Transactional
    public void update(Long commentId, CommentUpdateDto dto){
        Optional<Comment> byId = commentRepository.findById(commentId);
        if(byId.isEmpty()){
            throw new IllegalArgumentException("해당 id 없음.");
        }
        // 만약에 id에 맞는 엔티티 있으면 갖고와라
        Comment entity = byId.get();
        entity.update(dto);
    }

    // 삭제
    @Transactional
    public void delete(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
