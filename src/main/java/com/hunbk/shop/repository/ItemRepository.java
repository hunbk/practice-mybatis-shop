package com.hunbk.shop.repository;

import com.hunbk.shop.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Optional<Item> findByNo(Integer no);

    List<Item> findAll();

    List<Item> getMemberFavoriteItems(Integer memberNo);
}
