package com.example.blog.Service;

import com.example.blog.Repository.UserRepository;
import com.example.blog.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.blog.Dto.SignUpRequestDto;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }





    public void registerUser(SignUpRequestDto requestDto) {
        // 회원 ID 중복 확인
        String userid = requestDto.getId();
        Optional<User> found = userRepository.findByUserid(userid);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        String username = requestDto.getName();

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());




        User user = new User(userid, username,password );
        userRepository.save(user);
    }
}
