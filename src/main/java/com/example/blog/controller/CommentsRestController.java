package com.example.blog.controller;

import com.example.blog.Dto.CommentsRequestDto;
import com.example.blog.Repository.CommentsRepository;
import com.example.blog.Repository.PostRepository;
import com.example.blog.Security.UserDetailsImpl;
import com.example.blog.domain.Comments;
import com.example.blog.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsRestController {

    private final PostRepository postRepository;
    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsRestController(PostRepository postRepository, CommentsRepository commentsRepository) {
        this.postRepository = postRepository;
        this.commentsRepository = commentsRepository;
    }


    //댓글 불러오기
    @GetMapping("/api/blog/detail/{id}/comments")
    public List<Comments> getComments(@PathVariable Long id){
        Post post = postRepository.findById(id).orElseThrow(()->new RuntimeException("post not found"));

        return post.getComments();
    }

    //댓글 작성하기
    @PostMapping("/api/blog/detail/{id}/comments")
    public Comments writeComments(@PathVariable Long id, @RequestBody CommentsRequestDto commentsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){

        Post post = postRepository.findById(id).orElseThrow(
                ()->new RuntimeException("post not found"));
        Comments comments =
                new Comments(commentsRequestDto,userDetails.getUsername(),post);


        return commentsRepository.save(comments);
    }

    //댓글 수정하기
    @PatchMapping("/api/blog/detail/{id}/modify")
    public Comments modifyComments(@PathVariable Long id,@RequestBody CommentsRequestDto commentsRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){

        Comments comments = commentsRepository.findById(id).orElseThrow(
                ()->new RuntimeException());
        if (userDetails.getUsername() != comments.getUsername()){
            throw new IllegalArgumentException("작성자만이 수정할 수 있습니다.");
        }
        comments.setContent(commentsRequestDto.getContent());

        return commentsRepository.save(comments);
    }

    //댓글 삭제하기
    @DeleteMapping("/api/blog/detail/{id}/delete")
    public boolean deleteComments(@PathVariable Long id,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Comments comments = commentsRepository.findById(id).orElseThrow(
                ()->new RuntimeException());
        if (userDetails.getUsername() != comments.getUsername()){
            throw new IllegalArgumentException("작성자만이 삭제할 수 있습니다.");
        }
        commentsRepository.deleteById(id);
        return true;
    }

}
