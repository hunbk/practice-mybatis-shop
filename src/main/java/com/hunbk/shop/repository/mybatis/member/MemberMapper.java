package com.hunbk.shop.repository.mybatis.member;

import com.hunbk.shop.domain.CartItem;
import com.hunbk.shop.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    /**
     * 회원 기능
     */
    void save(Member member);

    Optional<Member> findByNo(Integer no);

    Optional<Member> findById(String id);

    boolean existsById(String id);

    boolean existsEmail(String email);

    /**
     * 찜 기능
     */
    boolean existsFavoriteItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    void addFavoriteItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    void cancelFavoriteItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    /**
     * 장바구니 기능
     */
    boolean existsCartItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    Optional<CartItem> findCartItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    List<CartItem> findCartItemByMemberNo(Integer memberNo);

    void addCartItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo, @Param("quantity") Integer quantity);

    void removeCartItem(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo);

    void updateCartItemQuantity(@Param("memberNo") Integer memberNo, @Param("itemNo") Integer itemNo, @Param("quantity") Integer quantity);
}
