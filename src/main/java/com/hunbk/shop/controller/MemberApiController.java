package com.hunbk.shop.controller;

import com.hunbk.shop.domain.AuthInfo;
import com.hunbk.shop.domain.CartItem;
import com.hunbk.shop.dto.item.CartItemQuantityRequest;
import com.hunbk.shop.dto.item.FavoriteRequest;
import com.hunbk.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/favorite")
    public ResponseEntity<Void> addFavoriteItem(@RequestBody FavoriteRequest favoriteRequest,
                                                @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //찜 목록에 존재
        if (memberService.existsFavoriteItem(authInfo.getMemberNo(), favoriteRequest.getItemNo())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        memberService.addFavoriteItem(authInfo.getMemberNo(), favoriteRequest.getItemNo());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/favorite")
    public ResponseEntity<Void> cancelFavoriteItem(@RequestBody FavoriteRequest favoriteRequest,
                                                   @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //찜 목록에 존재하지 않음
        if (!memberService.existsFavoriteItem(authInfo.getMemberNo(), favoriteRequest.getItemNo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        memberService.cancelFavoriteItem(authInfo.getMemberNo(), favoriteRequest.getItemNo());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cart/exists/{itemNo}")
    public ResponseEntity<Boolean> existsCartItem(@PathVariable Integer itemNo,
                                                  @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        return ResponseEntity.ok(memberService.existsCartItem(authInfo.getMemberNo(), itemNo));
    }

    @GetMapping("/cart/{itemNo}")
    public ResponseEntity<CartItem> findCartItem(@PathVariable Integer itemNo,
                                                 @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        CartItem cartItem = memberService.findCartItem(authInfo.getMemberNo(), itemNo).get();
        return ResponseEntity.ok().body(cartItem);
    }

    @PostMapping("/cart/{itemNo}")
    public ResponseEntity<CartItem> addCartItem(@PathVariable Integer itemNo,
                                                @RequestBody CartItemQuantityRequest cartItemQuantityRequest,
                                                @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //장바구니 목록에 존재함
        if (memberService.existsCartItem(authInfo.getMemberNo(), itemNo)) {
            CartItem cartItem = memberService.findCartItem(authInfo.getMemberNo(), itemNo).get();
            int updateQuantity = cartItem.getQuantity() + cartItemQuantityRequest.getQuantity();

            memberService.updateCartItemQuantity(authInfo.getMemberNo(), itemNo, updateQuantity);

            return ResponseEntity.ok().build();
        }

        memberService.addCartItem(authInfo.getMemberNo(), itemNo, cartItemQuantityRequest.getQuantity());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/cart/{itemNo}")
    public ResponseEntity<CartItem> removeCartItem(@PathVariable Integer itemNo,
                                                   @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //장바구니 목록에 존재하지 않음
        if (!memberService.existsCartItem(authInfo.getMemberNo(), itemNo)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        memberService.removeCartItem(authInfo.getMemberNo(), itemNo);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/cart/{itemNo}")
    public ResponseEntity<CartItem> updateCartItemQuantity(@PathVariable Integer itemNo,
                                                           @RequestBody CartItemQuantityRequest cartItemQuantityRequest,
                                                           @SessionAttribute(name = StringConst.AUTH_INFO, required = false) AuthInfo authInfo) {
        //비로그인
        if (authInfo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //장바구니 목록에 존재하지 않음
        if (!memberService.existsCartItem(authInfo.getMemberNo(), itemNo)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        memberService.updateCartItemQuantity(authInfo.getMemberNo(), itemNo, cartItemQuantityRequest.getQuantity());

        return ResponseEntity.ok().build();
    }
}
