package com.hyeok.back.controller;

import com.hyeok.back.Member.param.LoginReq;
import com.hyeok.back.Member.param.SignUpReq;
import com.hyeok.back.Member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HyeokController {

    @Resource
    private MemberService memberService;

    //로그인
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberLogin(LoginReq loginReq) {
        if(memberService.selectJoin(loginReq.getUserId(), loginReq.getPassword()))
            return "success";
        return "fail";
    }

    //회원가입
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String memberJoin(SignUpReq signUpReq) {
        if(memberService.saveJoin(signUpReq.getMember()))
            return "success";
        return "fail";
    }
}
