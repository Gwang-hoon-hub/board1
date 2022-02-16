package com.pang.project.week1.service;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.board.BoardRepository;
import com.pang.project.week1.dto.BoardListResponseDto;
import com.pang.project.week1.dto.BoardResponseDto;
import com.pang.project.week1.dto.BoardSaveRequestDto;
import com.pang.project.week1.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(BoardSaveRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글 없음 (id) = " + id)
        );
        ;
        board.update(requestDto);
        return id;
    }

    //TODO : 이 메소드 내체 모냐???..ㅅㅂ
    @Transactional
    public BoardResponseDto findById(Long id){
        Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없음")
        );
        return new BoardResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("사용자 없음")
        );
        boardRepository.delete(board);
    }

    @Transactional
    public List<BoardListResponseDto> findAllDesc() {
        List<BoardListResponseDto> dtoList = new ArrayList<>();
        List<Board> boardList = boardRepository.findAllDesc();
        for (Board board : boardList) {
            dtoList.add(board.toListDto());
        }
        return dtoList;
    }
}
