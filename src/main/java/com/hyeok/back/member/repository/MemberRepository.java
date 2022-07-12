package com.hyeok.back.member.repository;

import com.hyeok.back.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByUserId(String userId);
    MemberEntity findByNickName(String nickName);
}
