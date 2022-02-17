package com.pang.project.week1.controller;

import com.pang.project.week1.dto.BoardResponseDto;
import com.pang.project.week1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("boards", boardService.findAllDesc());
        return "index";
    }

    @GetMapping("/board/save")
    public String boardSave(){
        return "board-save";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "board-update";
    }
}
