package com.example.blog.domain;

import javax.persistence.*;

// 테이블 설정
@Entity
public class User {

    //기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //유저 아이디
    @Column
    private String userid;

    //유저 닉네임
    @Column
    private String username;

    //유저 패스워드
    @Column
    private String password;

    public User( String userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

}
