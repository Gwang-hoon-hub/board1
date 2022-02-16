package com.pang.project.week1.commentDto;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.board.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentSaveRequestDto {

    private String username;
    private String comment;

}
