package com.example.blog.controller;



import com.example.blog.Repository.PostRepository;
import com.example.blog.domain.Post;
import com.example.blog.Dto.PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PostRestController {
    private final PostRepository postRepository;

    @Autowired
    public PostRestController(PostRepository postRepository){
        this.postRepository= postRepository;
    }


    //게시글 목록
    @GetMapping("/api/postlist")
    public List<Post> getpost(){
        return postRepository.findAll();
    }

    //게시글 작성
    @PostMapping("/api/blog/write")
    public Post createpost(@RequestBody PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);

        //로그인 한 유저의 이름을 넣을 postREquestDto.setName 이 필요.


        return postRepository.save(post);
    }

    //게시글 댓글


}
