package com.hyeok.back.member.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginReq {
    /**
     * 로그인
     * @param userId
     * @param password
     */
    @NotNull
    private String userId;
    @NotNull
    private String password;
}
