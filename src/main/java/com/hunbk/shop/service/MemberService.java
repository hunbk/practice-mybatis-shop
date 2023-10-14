package com.hunbk.shop.service;

import com.hunbk.shop.domain.AuthInfo;
import com.hunbk.shop.domain.CartItem;
import com.hunbk.shop.domain.Member;
import com.hunbk.shop.dto.member.LoginForm;
import com.hunbk.shop.dto.member.SignupForm;
import com.hunbk.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 기능
     */
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

    /**
     * 찜 기능
     */
    @Transactional
    public void addFavoriteItem(Integer memberNo, Integer itemNo) {
        memberRepository.addFavoriteItem(memberNo, itemNo);
    }

    public boolean existsFavoriteItem(Integer memberNo, Integer itemNo) {
        return memberRepository.existsFavoriteItem(memberNo, itemNo);
    }

    @Transactional
    public void cancelFavoriteItem(Integer memberNo, Integer itemNo) {
        memberRepository.cancelFavoriteItem(memberNo, itemNo);
    }

    /**
     * 장바구니 기능
     */
    public boolean existsCartItem(Integer memberNo, Integer itemNo) {
        return memberRepository.existsCartItem(memberNo, itemNo);
    }

    public Optional<CartItem> findCartItem(Integer memberNo, Integer itemNo) {
        return memberRepository.findCartItem(memberNo, itemNo);
    }

    public List<CartItem> findCartItemByMemberNo(Integer memberNo) {
        return memberRepository.findCartItemByMemberNo(memberNo);
    }

    @Transactional
    public void addCartItem(Integer memberNo, Integer itemNo, Integer quantity) {
        memberRepository.addCartItem(memberNo, itemNo, quantity);
    }

    @Transactional
    public void removeCartItem(Integer memberNo, Integer itemNo) {
        memberRepository.removeCartItem(memberNo, itemNo);
    }

    @Transactional
    public void updateCartItemQuantity(Integer memberNo, Integer itemNo, Integer quantity) {
        memberRepository.updateCartItemQuantity(memberNo, itemNo, quantity);
    }
}
