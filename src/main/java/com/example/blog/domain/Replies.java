package com.example.blog.domain;


import javax.persistence.*;

@Entity
public class Replies {

    //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 댓글 쓴이
    @Column
    private String username;

    // 댓글 내용
    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comments comments;

    public Replies() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Replies(String username, String content) {
        this.username = username;
        this.content = content;
    }
    public Replies(String username, String content, Comments comments) {
        this.username = username;
        this.content = content;
        this.comments = comments;
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





}
