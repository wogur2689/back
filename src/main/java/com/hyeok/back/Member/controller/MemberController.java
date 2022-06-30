package com.hyeok.back.Member.controller;

import com.hyeok.back.Member.param.LoginReq;
import com.hyeok.back.Member.param.SignUpReq;
import com.hyeok.back.Member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "로그인 / 회원가입")
@RestController("/member/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //로그인
    @Operation(summary = "로그인", description = "아이디, 비밀번호 입력")
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberLogin(LoginReq loginReq) {
        if(memberService.selectJoin(loginReq.getUserId(), loginReq.getPassword())) return "redirect:/";
        else return "redirect:/member/loginError";
    }

    //회원가입
    @Operation(summary = "회원가입", description = "아이디, 비밀번호, 이름 입력")
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberJoin(SignUpReq signUpReq) {
        memberService.saveJoin(signUpReq.getMember());
        return "redirect:/";
    }
}
