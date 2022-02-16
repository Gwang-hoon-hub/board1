package com.pang.project.week1.controller;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.board.BoardRepository;
import com.pang.project.week1.board.Comment;
import com.pang.project.week1.board.CommentRepository;
import com.pang.project.week1.commentDto.CommentSaveRequestDto;
import com.pang.project.week1.commentDto.CommentUpdateDto;
import com.pang.project.week1.service.CommentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CommentApiController {

    /*
    * 생성
    * 삭제
    * 수정
    * 조회
    * */

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments/{id}")
    public Long createComment(@PathVariable Long id, @RequestBody CommentSaveRequestDto requestDto){
        commentService.createComment(id, requestDto);
        return id;
    }

    @GetMapping("/api/comments/{boardId}")
    public List<Comment> getAll(@PathVariable Long boardId){
//        Board board = boardRepository.findById(boardId)
        return commentService.getAll(boardId);
    }

    @DeleteMapping("api/comments/{commentId}")
    public void delete(@PathVariable Long commentId){
        commentService.delete(commentId);
    }

//    @PatchMapping("api/comments/{commentId}")
//    public void update(@PathVariable Long commentId, @RequestBody CommentUpdateDto dto){
//        commentService.update(commentId, dto);
//    }

    @PatchMapping("api/comments/{commentId}")
    public ResponseEntity<String> update(@PathVariable Long commentId, @RequestBody CommentUpdateDto dto){
        commentService.update(commentId, dto);
        return HttpStatus
    }


}


