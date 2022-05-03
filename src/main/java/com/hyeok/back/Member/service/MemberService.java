package com.hyeok.back.Member.service;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import com.hyeok.back.Member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public void saveJoin(Member member) {
        //member.setPassword(encryption(member.getPassword()));
        memberRepository.save(member.toEntity());
    }

    /* 로그인 */
    public Boolean selectJoin(Member member) {
        log.info("입력한 비밀번호 : " + member.getPassword());
        List<MemberEntity> result = memberRepository.findAll(); //findByUserIdAndPassword(member.getUserId(), member.getPassword());
        //member.setPassword(encryption(member.getPassword()));
        for(MemberEntity memberEntity : result) {
            if(memberEntity.getUserId().equals(member.getUserId())) {
                if (memberEntity.getPassword().equals(member.getPassword())) {
                    log.info("login success");
                    return true;
                } else {
                    log.info("저장된 비밀번호 : " + memberEntity.getPassword());
                    log.info("입력한 비밀번호 : " + member.getPassword());
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
