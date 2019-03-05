package com.daria.dev.controllers;

import com.daria.dev.model.Item;
import com.daria.dev.model.ItemUnit;
import com.daria.dev.repository.ItemUnitRepository;
import com.daria.dev.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemUnitRepository unitsRepository;

    @RequestMapping("")
    public List<Item> getItems() {
        List<ItemUnit> units = unitsRepository.findAll();
        List<Item> items = itemService.findAll();
        if (!items.isEmpty()) {
            Collection<ItemUnit> itemUnits =items.get(0).getItemUnits();
            System.out.println("Item units " + units);
        }
        return items;
    }

    @RequestMapping("/units")
    public List<ItemUnit> getUnits() {
        List<ItemUnit> units = unitsRepository.findAll();
        return units;
    }
}
