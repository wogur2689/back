package com.hyeok.back.member.dto;

import com.hyeok.back.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    private Long id;         //아이디
    private String userId;   //유저 아이디
    private String name;     //이름
    private String password; //비밀번호
    private String address;  //주소
    private String phoneNumber; //전화번호

    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .password(password)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
    }

    @Builder
    public Member(Long id, String userId, String name, String password, String address, String phoneNumber) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
