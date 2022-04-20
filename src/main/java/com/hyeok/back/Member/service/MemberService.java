package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    /* 회원가입 */
    public void savejoin(Member member) {
        /* userID 중복체크 */
        if(memberRepository.findById(member.getId()).isPresent()) {
            return;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        MemberEntity memberEntity = MemberEntity.builder()
                .id(member.getId())
                .userID(member.getUserID())
                .name(member.getName())
                .password(member.getPassword())
                .build();
        memberRepository.save(memberEntity);
    }
}
