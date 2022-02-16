package com.pang.project.week1.dto;

import com.pang.project.week1.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private String username;

    @Builder
    public BoardSaveRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .username(username)
                .build();
    }
}
