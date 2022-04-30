package com.hyeok.back.controller;

import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class hyeokController {

    private MemberService memberService;

    //메인 페이지
    @GetMapping("/")
    public String home() {
        return "index";
    }

    //로그인 페이지
    @GetMapping("/member/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/member/login")
    public String memberLogin(Member member) {
        Boolean result = memberService.selectJoin(member);
        if(result) return "redirect:/";
        else return "/member/loginError";
    }

    //회원가입 페이지
    @GetMapping("/member/signup")
    public String signup() { return "/member/signup";}

    //회원가입
    @PostMapping("/member/signup")
    public String memberJoin(Member member) {
        log.info("회원가입");
        memberService.saveJoin(member);
        log.info("회원가입 완료");
        return "index.html";
    }
}
