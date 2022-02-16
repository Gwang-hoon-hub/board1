package com.pang.project.week1.commentDto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentListResponseDto {

    private String username;
    private String comment;
    private LocalDateTime modifiedDate;

    @Builder
    public CommentListResponseDto(String username, String comment, LocalDateTime modifiedDate) {
        this.username = username;
        this.comment = comment;
        this.modifiedDate = modifiedDate;
    }

}
