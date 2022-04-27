package com.hyeok.back.controller;

import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
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

    @PostMapping("/member/signup")
    public String memberJoin(Member member) {
        memberService.saveJoin(member);
        return "redirect:/";
    }
}
