package com.example.blog.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 클래스 내에 있는 모든 필드에 대해 getter/setter , equals, hashCode, toString 등의 메소드 자동생성
@Data

//모든 필드를 파라미터로 받는 생성자를 자동으로 생성
@AllArgsConstructor

//파라미터가 없는 기본 생성자를 자동으로 생성
@NoArgsConstructor
public class SingUpRequsetDto {

    //닉네임은 최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)로 구성
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9-_]{3,10}$" , message = "아이디는 최소 3자 이상입니다.")
    private String username;

    // 최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 4, message = "비밀번호는 최소 4자에서 최대 16자 입니다.")
    private String password;

    private String email;

    @NotBlank(message = "2차 비밀번호는 필수 입력 값입니다.")
    private String chekpassword;

}
