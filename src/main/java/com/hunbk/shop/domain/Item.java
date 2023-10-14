package com.hunbk.shop.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {

    private Integer itemNo;
    private String name;
    private String category;
    private Integer price;
    private Integer stock;
    private String description;
    private String imagePath;
    private Member member; //TODO: rename seller

    @Builder
    public Item(String name, String category, Integer price, Integer stock, String description, String imagePath, Member member) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.imagePath = imagePath;
        this.member = member;
    }
}
