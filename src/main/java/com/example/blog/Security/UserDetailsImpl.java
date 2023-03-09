package com.example.blog.Security;

import com.example.blog.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    //사용자의 권한 정보를 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    // 사용자의 비밀번호를 리턴
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    // 사용자의 이름을 리턴
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    //사용자의 계정이 만료되었는지 여부를 리턴
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // 사용자 계정이 잠겨있는지 여부를 리턴
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //사용자의 인증 정보가 만료되었는지 여부를 리턴
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // 사용자 계정이 활성화 되어있는지 여부를 리턴
    public boolean isEnabled() {

        // 예를 들어 1년동안 로그인을 안한 사용자가 있을경우 휴면계정으로 전환 하기로 했을때
        // 현재시간 - 로그인 시간 => 1년을 초과하면 false
        return true;
    }
}
