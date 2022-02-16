package com.pang.project.week1.controller;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.dto.BoardListResponseDto;
import com.pang.project.week1.dto.BoardSaveRequestDto;
import com.pang.project.week1.dto.BoardUpdateRequestDto;
import com.pang.project.week1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardApiController {

    private final BoardService boardService;


    @PostMapping("/api/boards")
    public Board save(@RequestBody BoardSaveRequestDto requestDto){
        return boardService.createBoard(requestDto);
    }

    @PatchMapping("/api/boards/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/boards/{id}")
    public Long delete(@PathVariable Long id){
        boardService.delete(id);
        return id;
    }

    @GetMapping("/api/boards")
    public List<BoardListResponseDto> getAll(){
//        List<BoardListResponseDto> dtoList = new ArrayList<>();
//        dtoList = boardService.findAllDesc();
//        for (BoardListResponseDto dto : dtoList) {
//            System.out.println("dto = " + dto.toString());
//        }
        return boardService.findAllDesc();
    }

}
