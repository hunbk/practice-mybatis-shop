package com.hunbk.shop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartItem {

    private Item item;
    private Member member;
    private Integer quantity;

}
