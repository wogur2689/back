package com.hyeok.back.Member.service;

import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    /* 회원가입 */
    public void saveJoin(Member member) {
        log.info("저장 시작");
        memberRepository.save(member.toEntity());
        log.info("저장 완료");
    }

    /* 로그인 */
    public Boolean selectJoin(Member member) {
        Boolean result = memberRepository.findByUserIdAndPassword(member.getUserId(), member.getPassword());
        if(result) return true;
        else return false;
    }
}
