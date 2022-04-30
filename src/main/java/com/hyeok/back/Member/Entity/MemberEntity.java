package com.hyeok.back.Member.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Transient
    private String verify_password;

    @PostLoad
    public void postLoad() {
        this.verify_password = password;
    }

    @Builder
    public MemberEntity(Long id, String userId, String name, String password, String verify_password) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.verify_password = verify_password;
    }
}
