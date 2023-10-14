package com.hunbk.shop.repository.mybatis.member;

import com.hunbk.shop.domain.CartItem;
import com.hunbk.shop.domain.Member;
import com.hunbk.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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

    @Override
    public boolean existsFavoriteItem(Integer memberNo, Integer itemNo) {
        return memberMapper.existsFavoriteItem(memberNo, itemNo);
    }

    @Override
    public void addFavoriteItem(Integer memberNo, Integer itemNo) {
        memberMapper.addFavoriteItem(memberNo, itemNo);
    }

    @Override
    public void cancelFavoriteItem(Integer memberNo, Integer itemNo) {
        memberMapper.cancelFavoriteItem(memberNo, itemNo);
    }

    @Override
    public boolean existsCartItem(Integer memberNo, Integer itemNo) {
        return memberMapper.existsCartItem(memberNo, itemNo);
    }

    @Override
    public Optional<CartItem> findCartItem(Integer memberNo, Integer itemNo) {
        return memberMapper.findCartItem(memberNo, itemNo);
    }

    @Override
    public List<CartItem> findCartItemByMemberNo(Integer memberNo) {
        return memberMapper.findCartItemByMemberNo(memberNo);
    }

    @Override
    public void addCartItem(Integer memberNo, Integer itemNo, Integer quantity) {
        memberMapper.addCartItem(memberNo, itemNo, quantity);
    }

    @Override
    public void removeCartItem(Integer memberNo, Integer itemNo) {
        memberMapper.removeCartItem(memberNo, itemNo);
    }

    @Override
    public void updateCartItemQuantity(Integer memberNo, Integer itemNo, Integer quantity) {
        memberMapper.updateCartItemQuantity(memberNo, itemNo, quantity);
    }
}
