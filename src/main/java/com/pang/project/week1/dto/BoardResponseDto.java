package com.pang.project.week1.dto;

import com.pang.project.week1.board.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String username;
    private String content;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.username = entity.getUsername();
        this.title = entity.getTitle();
    }

}
