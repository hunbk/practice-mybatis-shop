package com.hunbk.shop.repository.mybatis.member;

import com.hunbk.shop.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    void save(Member member);

    Optional<Member> findByNo(Integer no);

    Optional<Member> findById(String id);

    boolean existsById(String id);

    boolean existsEmail(String email);

}
