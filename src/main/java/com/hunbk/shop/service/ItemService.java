package com.hunbk.shop.service;

import com.hunbk.shop.domain.Item;
import com.hunbk.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    public Optional<Item> findByNo(Integer no) {

        return itemRepository.findByNo(no);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> getMemberFavoriteItems(Integer memberNo) {
        return itemRepository.getMemberFavoriteItems(memberNo);
    }
}
