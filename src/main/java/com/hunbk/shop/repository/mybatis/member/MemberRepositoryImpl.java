package com.hunbk.shop.repository.mybatis.member;

import com.hunbk.shop.domain.Member;
import com.hunbk.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member save(Member member) {
        memberMapper.save(member);
        return member;
    }

    @Override
    public Optional<Member> findByNo(Integer no) {
        return memberMapper.findByNo(no);
    }

    @Override
    public Optional<Member> findById(String id) {
        return memberMapper.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return memberMapper.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberMapper.existsEmail(email);
    }
}
