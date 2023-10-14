package com.hunbk.shop.repository;

import com.hunbk.shop.domain.CartItem;
import com.hunbk.shop.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    /**
     * 회원 기능
     */
    Member save(Member member);

    Optional<Member> findByNo(Integer no);

    Optional<Member> findById(String id);

    boolean existsById(String id);

    boolean existsByEmail(String email);

    /**
     * 찜 기능
     */
    boolean existsFavoriteItem(Integer memberNo, Integer itemNo);

    void addFavoriteItem(Integer memberNo, Integer itemNo);

    void cancelFavoriteItem(Integer memberNo, Integer itemNo);

    /**
     * 장바구니 기능
     */
    boolean existsCartItem(Integer memberNo, Integer itemNo);

    Optional<CartItem> findCartItem(Integer memberNo, Integer itemNo);

    List<CartItem> findCartItemByMemberNo(Integer memberNo);

    void addCartItem(Integer memberNo, Integer itemNo, Integer quantity);

    void removeCartItem(Integer memberNo, Integer itemNo);

    void updateCartItemQuantity(Integer memberNo, Integer itemNo, Integer quantity);

}
