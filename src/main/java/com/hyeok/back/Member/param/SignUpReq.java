package com.hyeok.back.Member.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hyeok.back.Member.dto.Member;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SignUpReq {

    /**
     * 회원가입
     */
    private Member member;
}
