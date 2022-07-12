package com.hyeok.back.member.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SignUpReq {

    /**
     * 회원가입
     */
    private String userId;
    private String name;
    private String nickName;
    private String password;
    private String address;
    private String phoneNumber;
}
