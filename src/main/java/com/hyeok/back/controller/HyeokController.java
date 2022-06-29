package com.hyeok.back.controller;

import com.hyeok.back.Member.param.LoginReq;
import com.hyeok.back.Member.param.SignUpReq;
import com.hyeok.back.Member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class HyeokController {

    private MemberService memberService;

    //로그인
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberLogin(LoginReq loginReq) {
        if(memberService.selectJoin(loginReq.getUserId(), loginReq.getPassword()))
            return "redirect:/";
        return "redirect:/member/loginError";
    }

    //회원가입
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberJoin(SignUpReq signUpReq) {
        memberService.saveJoin(signUpReq.getMember());
        return "redirect:/";
    }
}
