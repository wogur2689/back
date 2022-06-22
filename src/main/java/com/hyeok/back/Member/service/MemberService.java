package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /* 비밀번호 암호화 */
    public String encryption(String password) {
        return passwordEncoder.encode(password);
    }

    /* 회원가입 */
    @Transactional
    public void saveJoin(Member member) {
        member.setPassword(encryption(member.getPassword()));
        memberRepository.save(member.toEntity());
    }

    /* 로그인 */
    @Transactional
    public Boolean selectJoin(String id, String pw) {
        MemberEntity result = selectMember(id);

        //id 조회
        if(!result.getUserId().equals(id)) {
            return false; //id 없음.
        }

        //pw 조회
        if (!passwordEncoder.matches(pw, result.getPassword())) {
             return false; //비밀번호 불일치
        }

        return true; //로그인 성공
    }

    /* 입력한 ID로 조회 */
    @Transactional(readOnly = true)
    public MemberEntity selectMember(String id) {
        return memberRepository.findByUserId(id);
    }
}
