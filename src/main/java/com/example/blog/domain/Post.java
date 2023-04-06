package com.example.blog.domain;

import com.example.blog.Dto.PostRequestDto;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    //글 제목
    @Setter
    @Column
    private String title;

    //글쓴이
    @Column
    private String nickname;

    //글내용
    @Setter
    @Column
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userAccount_id")
    private UserAccount user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Replies> replies = new ArrayList<>();

    public Post() {
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNickname() {
        return nickname;
    }

    public String getContents() {
        return contents;
    }

    public Post(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.nickname = postRequestDto.getNickname();
        this.contents = postRequestDto.getContents();
    }
}
