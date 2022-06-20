package com.hyeok.back.Member.repository;

import com.hyeok.back.Member.Entity.MemberEntity;
import com.hyeok.back.Member.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Query(name = "interface.login")
    MemberEntity findByUserId(@Param("user_id") String userId);
}
