package com.pang.project.week1.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardUpdateRequestDto {

    private String title;
    private String content;
    private String username;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
