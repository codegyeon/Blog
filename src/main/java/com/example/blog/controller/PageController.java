package com.example.blog.controller;


import com.example.blog.Repository.PostRepository;
import com.example.blog.Security.UserDetailsImpl;
import com.example.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PageController {
    private final PostRepository postRepository;

    @Autowired
    public PageController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


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
        if(userDetails != null){
            model.addAttribute("username",userDetails.getUsername());
        }
        return "postdetail";
    }

    //게시글 수정 페이지
    @GetMapping("/postmodify/{id}")
    public String postmodify(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id,Model model){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        if (userDetails.getUsername() != post.getNickname()){
            model.addAttribute("keys","자신의 게시글만 지울수 있습니다.");
            return "redirect:/postdetail/"+id ;
        }

        return "postmodify";
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
