package com.example.blog.Repository;

import com.example.blog.domain.Replies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepliesRepository extends JpaRepository<Replies,Long> {
}
