package com.pang.project.week1.controller;

import com.pang.project.week1.dto.HelloResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
        // @RequestParm
        // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
        // 외부에서 name이라고 넘긴 파리미터를 String name에 저장한다.
    }


}
