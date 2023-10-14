package com.hunbk.shop.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {

    private Integer memberNo;
    private String id;
    private String password;
    private String name;
    private String email;

    @Builder
    public Member(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
