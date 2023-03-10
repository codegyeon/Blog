package com.example.blog.controller;



import com.example.blog.Repository.PostRepository;
import com.example.blog.Repository.UserRepository;
import com.example.blog.Security.UserDetailsImpl;
import com.example.blog.domain.Post;
import com.example.blog.Dto.PostRequestDto;
import com.example.blog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PostRestController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostRestController(PostRepository postRepository, UserRepository userRepository){
        this.postRepository= postRepository;
        this.userRepository = userRepository;
    }


    //게시글 목록
    @GetMapping("/api/postlist")
    public List<Post> getPost(){
        return postRepository.findAll();
    }

    //게시글 상세페이지
    @GetMapping("/api/blog/detail/{id}")
    public Post getDetailPost(@PathVariable Long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return post;
    }




    //게시글 작성
    @PostMapping("/api/blog/write")
    public Post createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        String username = userDetails.getUsername();

        //로그인 한 유저의 이름을 넣을 postREquestDto.setName 이 필요.
        postRequestDto.setUsername(username);
        User user = userRepository.findByUsername(username).orElseThrow(
                ()->new IllegalArgumentException("UserName 이 존재하지 않습니다."));



        Post post = new Post(postRequestDto);
        post.setUser(user);


        return postRepository.save(post);
    }

    //게시글 수정
    @PatchMapping("/api/blog/modify/{id}")
    public Post modifyPost (@PathVariable Long id, @RequestBody PostRequestDto postRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        //TODO : 수정 , 삭제가 필요

    }
    //게시글 삭제
    @DeleteMapping("/api/blog/delete/{id}")
    public boolean deletePost (@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){

    }

}
