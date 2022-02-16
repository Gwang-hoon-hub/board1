package com.pang.project.week1.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {

    private Long id;
    private String title;
    private String username;
    private LocalDateTime modifiedDate;

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    @Builder
    public BoardListResponseDto(Long id, String title, String username, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.modifiedDate = modifiedDate;
    }
}

