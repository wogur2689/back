package com.hyeok.back.Member.dto;

import com.hyeok.back.Member.Entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member {
    private Long id;         //아이디
    private String userId;   //유저 아이디
    private String name;     //이름
    private String password; //비밀번호

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .password(password)
                .build();
    }

    @Builder
    public Member(Long id, String userId, String name, String password) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
