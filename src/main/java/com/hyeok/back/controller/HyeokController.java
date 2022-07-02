package com.hyeok.back.controller;

import com.hyeok.back.member.param.LoginReq;
import com.hyeok.back.member.param.SignUpReq;
import com.hyeok.back.member.service.MemberService;
import com.hyeok.back.common.CommonResult;
import com.hyeok.back.common.HyeokApi;
import com.hyeok.back.enums.ApiCode;
import com.hyeok.back.hyeokException.HyeokException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "로그인 / 회원가입")
@Slf4j
@RestController
@RequestMapping(path = "/member/api")
public class HyeokController {

    @Resource
    private MemberService memberService;

    @Operation(summary = "로그인", description = "아이디, 비밀번호 입력")
    @PostMapping(path = "/login")
    public HyeokApi memberLogin(@RequestBody LoginReq loginReq) {
        if(memberService.selectJoin(loginReq.getUserId(), loginReq.getPassword())) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            throw new HyeokException(ApiCode.API_5000);
        }
    }

    //회원가입
    @Operation(summary = "회원가입", description = "아이디, 비밀번호, 이름 입력")
    @PostMapping(path = "/signup")
    public HyeokApi memberJoin(@RequestBody SignUpReq signUpReq) {
        if(memberService.saveJoin(signUpReq)) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            throw new HyeokException(ApiCode.API_5000);
        }
    }
}
