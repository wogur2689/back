package com.hyeok.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id;       //아이디
    private String userID;   //유저 아이디
    private String name;     //이름
    private String password; //비밀번호

    public Member(String id, String userID, String name, String password) {
        this.id = id;
        this.userID = userID;
        this.name = name;
        this.password = password;
    }
}
