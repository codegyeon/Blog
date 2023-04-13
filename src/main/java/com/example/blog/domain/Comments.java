package com.example.blog.domain;

import com.example.blog.Dto.CommentsRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comments {

    //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 댓글 쓴이
    @Column
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // 댓글 내용
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


    public List<Replies> getReplies() {
        return replies;
    }

    @OneToMany(mappedBy = "comments",cascade = CascadeType.ALL)
    private List<Replies> replies = new ArrayList<>();


    public Comments() {
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comments(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public Comments(CommentsRequestDto commentsRequestDto,String username,Post post){
        this.content = commentsRequestDto.getContent();
        this.username=username;
        this.post = post;
    }
}
