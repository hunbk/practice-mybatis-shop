package com.hunbk.shop.controller;

import com.hunbk.shop.domain.Item;
import com.hunbk.shop.dto.item.ItemListResponse;
import com.hunbk.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<ItemListResponse> items() {
        return ResponseEntity.ok(new ItemListResponse(itemService.findAll()));
    }

    @GetMapping("/{no}")
    public ResponseEntity<Item> item(@PathVariable Integer no) {
        return ResponseEntity.ok(itemService.findByNo(no).get());
    }

}
