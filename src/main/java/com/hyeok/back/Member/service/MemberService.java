package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    /* 회원가입 */
    public void saveJoin(Member member) {
        /* userID 중복체크 */
        if(memberRepository.findById(member.getId()).isPresent()) {
            return;
        }

        MemberEntity memberEntity = MemberEntity.builder()
                .id(member.getId())
                .userID(member.getUserID())
                .name(member.getName())
                .password(member.getPassword())
                .build();
        memberRepository.save(memberEntity);
    }

    /* 로그인 */
    public Boolean selectJoin(Member member) {
        Boolean result = memberRepository.findByUserIdAndPassword(member.getUserID(), member.getPassword());
        if(result) return true;
        else return false;
    }
}
