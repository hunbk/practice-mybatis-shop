package com.hunbk.shop.service;

import com.hunbk.shop.domain.AuthInfo;
import com.hunbk.shop.domain.Member;
import com.hunbk.shop.dto.member.LoginForm;
import com.hunbk.shop.dto.member.SignupForm;
import com.hunbk.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signup(SignupForm signupForm) {
        Member member = Member.builder()
                .id(signupForm.getId())
                .password(signupForm.getPassword())
                .name(signupForm.getName())
                .email(signupForm.getEmail())
                .build();
        return memberRepository.save(member);
    }

    public AuthInfo login(LoginForm loginForm) {
        return memberRepository.findById(loginForm.getId())
                .filter(m -> m.getPassword().equals(loginForm.getPassword()))
                .map(AuthInfo::createAuth)
                .orElse(null);
    }

    public Optional<Member> findByNo(Integer no) {
        return memberRepository.findByNo(no);
    }

    public Optional<Member> findById(String id) {
        return memberRepository.findById(id);
    }

    public boolean existsId(String id) {
        return memberRepository.existsById(id);
    }

    public boolean existsEmail(String email) {
        return memberRepository.existsByEmail(email);
    }
}
