package com.hyeok.back.member.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginReq {
    /**
     * 로그인
     * @param Id
     * @param password
     */
    private String userId;
    private String password;
}
