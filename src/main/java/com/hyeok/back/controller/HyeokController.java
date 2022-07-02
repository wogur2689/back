package com.hyeok.back.controller;

import com.hyeok.back.Member.param.LoginReq;
import com.hyeok.back.Member.param.SignUpReq;
import com.hyeok.back.Member.service.MemberService;
import com.hyeok.back.common.CommonResult;
import com.hyeok.back.common.HyeokApi;
import com.hyeok.back.enums.ApiCode;
import com.hyeok.back.hyeokException.HyeokException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HyeokController {

    @Resource
    private MemberService memberService;

    //로그인
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
    @PostMapping(path = "/signup")
    public HyeokApi memberJoin(@RequestBody SignUpReq signUpReq) {
        if(memberService.saveJoin(signUpReq.getMember())) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            throw new HyeokException(ApiCode.API_5000);
        }
    }
}
