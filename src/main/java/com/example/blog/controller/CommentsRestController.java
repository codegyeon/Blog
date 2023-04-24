package com.example.blog.controller;

import com.example.blog.Dto.CommentsRequestDto;
import com.example.blog.Repository.CommentsRepository;
import com.example.blog.Repository.PostRepository;
import com.example.blog.Security.UserDetailsImpl;
import com.example.blog.Service.CommentsService;
import com.example.blog.domain.Comments;
import com.example.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsRestController {
    private final CommentsService commentsService;

    @Autowired
    public CommentsRestController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    //댓글 불러오기
    @GetMapping("/api/blog/detail/{id}/comments")
    public List<Comments> getComments(@PathVariable Long id){
        return commentsService.getComments(id);
    }

    //댓글 작성하기
    @PostMapping("/api/blog/detail/{id}/comments")
    public Comments writeComments(@PathVariable Long id, @RequestBody CommentsRequestDto commentsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentsService.writeComments(id,commentsRequestDto,userDetails);
    }

    //댓글 수정하기
    @PatchMapping("/api/blog/detail/{id}/modify")
    public Comments modifyComments(@PathVariable Long id,@RequestBody CommentsRequestDto commentsRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentsService.modifyComments(id,commentsRequestDto,userDetails);
    }

    //댓글 삭제하기
    @DeleteMapping("/api/blog/detail/{id}/delete")
    public boolean deleteComments(@PathVariable Long id,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentsService.deleteComments(id,userDetails);
    }

}
