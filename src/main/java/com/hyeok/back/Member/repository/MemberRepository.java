package com.hyeok.back.Member.repository;

import com.hyeok.back.Member.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    /* 회원정보 조회 */
    Boolean findByUserIdAndPassword(String userId, String password);
}
