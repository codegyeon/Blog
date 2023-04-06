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
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public void setPost(Post post) {
        this.post = post;
    }

    public Replies(String username, String comments) {
        this.username = username;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getComments() {
        return comments;
    }





}
