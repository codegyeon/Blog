package com.example.blog.Repository;

import com.example.blog.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    //TODO : 해당 post_id 의 댓글을 꺼내야함.
}
