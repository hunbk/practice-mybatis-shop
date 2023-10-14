package com.hunbk.shop.controller;

import com.hunbk.shop.domain.Item;
import com.hunbk.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public String itemList(Model model) {
        //TODO: 상품 검색
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);

        return "items/itemList";
    }

    @GetMapping("/{no}")
    public String item(@PathVariable Integer no, Model model) {
        Item item = itemService.findByNo(no).get();
        model.addAttribute("item", item);

        return "items/itemView";
    }
}
