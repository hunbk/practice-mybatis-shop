package com.hunbk.shop.repository;

import com.hunbk.shop.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findByNo(Integer no);

    Optional<Member> findById(String id);

    boolean existsById(String id);

    boolean existsByEmail(String email);

}
