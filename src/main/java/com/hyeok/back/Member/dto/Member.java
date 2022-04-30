package com.hyeok.back.Member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private Long id;         //아이디
    private String userId;   //유저 아이디
    private String name;     //이름
    private String password; //비밀번호

    @Builder
    public Member(Long id, String userId, String name, String password) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
