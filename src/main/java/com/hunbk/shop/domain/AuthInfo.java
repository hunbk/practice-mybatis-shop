package com.hunbk.shop.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthInfo {

    private Integer memberNo;
    private String name;

    public static AuthInfo createAuth(Member member) {
        return new AuthInfo(member.getMemberNo(), member.getName());
    }
}
