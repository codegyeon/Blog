package com.example.blog.domain;

import com.example.blog.Dto.PostRequestDto;

import javax.persistence.*;

@Entity
public class Post {

    //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    //글 제목
    @Column
    private String title;

    //글쓴이
    @Column
    private String username;

    //글내용
    @Column
    private String contents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Post(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.username = postRequestDto.getUsername();
        this.contents = postRequestDto.getContents();
    }
}
