package com.example.blog.controller;


import com.example.blog.Security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    //메인페이지
    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        //TODO: UserInterceptor 를 이용해 리팩토링 해보자.
        //현재 인증된 사용자의 정보 추출후 전달.(로그인을 한 사용자의 유저네임 전달.)
        if(userDetails != null){
            model.addAttribute("username",userDetails.getUsername());
        }

        return "index";
    }

    //게시글 상세 페이지
    @GetMapping("/postdetail/{id}")
    public String postdetail(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        model.addAttribute("username",userDetails.getUsername());
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
    public String write(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model){
        model.addAttribute("username",userDetails.getUsername());
        return "write";
    }

}
