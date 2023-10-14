package com.hunbk.shop.dto.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FavoriteRequest {
    private Integer itemNo;

    public FavoriteRequest(Integer itemNo) {
        this.itemNo = itemNo;
    }
}
