package com.example.blog.Repository;


import com.example.blog.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserid(String userid);
    Optional<UserAccount> findByUsername(String username);
}
