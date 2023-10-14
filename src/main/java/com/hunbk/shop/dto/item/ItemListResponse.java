package com.hunbk.shop.dto.item;

import com.hunbk.shop.domain.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ItemListResponse {

    private List<Item> data;

    public ItemListResponse(List<Item> data) {
        this.data = data;
    }
}
