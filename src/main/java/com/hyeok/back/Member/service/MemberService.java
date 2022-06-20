package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
public class MemberService implements UserDetailsService {

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
        List<MemberEntity> result = selectMember();
        for(MemberEntity memberEntity : result) {
            if(memberEntity.getUserId().equals(id)) {
                if (passwordEncoder.matches(pw, memberEntity.getPassword())) return true;
                else return false; //비밀번호 불일치
            }
        }
        return false; //id 없음.
    }

    /* 전체 멤버 조회 */
    @Transactional(readOnly = true)
    public List<MemberEntity> selectMember() {
        return memberRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
