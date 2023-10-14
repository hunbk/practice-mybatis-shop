package com.hunbk.shop.repository.mybatis.item;

import com.hunbk.shop.domain.Item;
import com.hunbk.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemMapper itemMapper;

    @Override
    public Optional<Item> findByNo(Integer no) {
        return itemMapper.findByNo(no);
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public List<Item> getMemberFavoriteItems(Integer memberNo) {
        return itemMapper.getMemberFavoriteItems(memberNo);
    }
}
