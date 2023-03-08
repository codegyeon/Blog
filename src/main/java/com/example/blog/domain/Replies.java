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

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }




}
