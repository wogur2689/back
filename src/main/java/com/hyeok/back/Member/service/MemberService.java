package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    /* 비밀번호 암호화 */
   //public String encryption(String password) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //비밀번호 암호화
        //return passwordEncoder.encode(password);
    //}


    /* 회원가입 */
    @Transactional
    public void saveJoin(Member member) {
        //member.setPassword(encryption(member.getPassword()));
        memberRepository.save(member.toEntity());
    }

    /* 로그인 */
    public Boolean selectJoin(String id, String pw) {
        List<MemberEntity> result = memberRepository.findAll();
        //member.setPassword(encryption(member.getPassword()));
        for(MemberEntity memberEntity : result) {
            if(memberEntity.getUserId().equals(id)) {
                if (memberEntity.getPassword().equals(pw)) {
                    log.info("login success");
                    return true;
                } else {
                    log.info("비밀번호가 틀렸습니다.");
                    return false;
                }
            } else {
                log.info("존재하지 않는 아이디입니다.");
                return false;
            }
        }
        log.info("login fail");
        return false;
    }
}
