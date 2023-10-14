package com.hunbk.shop.repository.mybatis.item;

import com.hunbk.shop.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    Optional<Item> findByNo(Integer no);

    List<Item> findAll();

    List<Item> getMemberFavoriteItems(Integer memberNo);
}
