package com.pang.project.week1.board;

import com.pang.project.week1.dto.BoardListResponseDto;
import com.pang.project.week1.dto.BoardSaveRequestDto;
import com.pang.project.week1.dto.BoardUpdateRequestDto;
import com.pang.project.week1.model.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

//    @OneToMany(mappedBy = "board")
//    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String title, String username, String content) {
        this.title = title;
        this.username = username;
        this.content = content;
    }

    public Board(BoardSaveRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }

    public BoardListResponseDto toListDto(){
        return BoardListResponseDto.builder()
                .id(id)
                .title(title)
                .username(username)
                .modifiedDate(getModifiedAt())
                .build();
    }

    public void update(BoardUpdateRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }
}
