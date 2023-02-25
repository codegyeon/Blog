package com.example.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    //메인페이지
    @GetMapping("/")
    public String home(){
        return "index";
    }

    //게시글 상세 페이지
    @GetMapping("/postdetail/{id}")
    public String postdetail(){
        return "postdetail";
    }

    //로그인 페이지
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //회원가입 페이지
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    //게시글작성 페이지
    @GetMapping("/write")
    public String write(){
        return "write";
    }

}
