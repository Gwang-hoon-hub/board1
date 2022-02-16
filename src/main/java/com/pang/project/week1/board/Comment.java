package com.pang.project.week1.board;

import com.pang.project.week1.board.Board;
import com.pang.project.week1.commentDto.CommentSaveRequestDto;
import com.pang.project.week1.commentDto.CommentUpdateDto;
import com.pang.project.week1.model.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long commentId;

    private String username;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;

    @Builder
    public Comment(String username, String comment, Board board) {
        this.username = username;
        this.comment = comment;
        this.board = board;
    }

    public void addBoard(Board board){
        this.board = board;
    }

    public Comment(CommentSaveRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.comment = requestDto.getComment();
    }

    public void update(CommentUpdateDto dto){
        this.comment = dto.getComment();
    }
}
