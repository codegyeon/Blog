package com.example.blog.controller;

import com.example.blog.Dto.SignUpRequestDto;
import com.example.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute @Valid SignUpRequestDto SignUpRequestDto, Errors errors, Model model){
        // errors.hasErrors : 오류가 있는지 여부를 확인
        if (errors.hasErrors()) {

            List<ObjectError> errorList = errors.getAllErrors(); // 모든 오류 정보 가져오기
            for (ObjectError error : errorList) {
                model.addAttribute("keys", error.getDefaultMessage()); // 오류 메시지를 errorMsg 속성에 추가
            }
            return "signup";
        }

        // 1차 비밀번호와 2차 비밀번호가 다를경우
        if(!SignUpRequestDto.getPassword().equals(SignUpRequestDto.getCheckedpassword())){
            model.addAttribute("keys" , "비밀번호가 다릅니다..");
            return "signup";
        }

        // 이름과 비밀번호가 같을경우
        if(SignUpRequestDto.getUsername().equals(SignUpRequestDto.getPassword())){
            model.addAttribute("keys","아이디와 비밀번호는 같을 수 없습니다.");
            return "signup";
        }

        try {
            userService.registerUser(SignUpRequestDto);
        }catch (Exception e){
            model.addAttribute("keys","중복된 사용자 ID 가 존재합니다.");
            return "signup";
        }



        model.addAttribute("keys","회원가입 성공!");


        return "login";
    }
}
